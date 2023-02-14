package faconnicolas.project.tetris.model.grid;

import faconnicolas.project.tetris.model.color.Color;
import faconnicolas.project.tetris.model.player.Player;
import faconnicolas.project.tetris.model.tetriminos.Tetriminos;
import faconnicolas.project.tetris.view.Drawable;

import java.awt.*;
import java.util.ArrayList;

/**
 * Grid is the Tetris game class. Used to represent the container.
 */
public class Grid implements Drawable, IGrid {

    /**
     * Width of the grid
     */
    public static final int GRID_WIDTH = 11;

    /**
     * Height of the grid
     */
    public static final int GRID_HEIGHT = 22;

    /**
     * grid lines' container
     */
    private final ArrayList<Line> lines = new ArrayList<>();

    private Tetriminos tetriminos;

    /**
     * Grid constructor, init grid
     */
    public Grid(Tetriminos tetriminos) {
        this.tetriminos = tetriminos;
        initGrid();
    }

    /**
     * init the grid, called in the constructor.
     */
    @Override
    public void initGrid() {
        Line line = new Line();
        for (int i = 0; i < GRID_WIDTH; i++)
            line.add(Color.GREY, 0);

        lines.add(line);

        for (int i = 1; i < GRID_HEIGHT - 1; i++)
            lines.add(new Line(i));

        line = new Line();
        for (int i = 0; i < GRID_WIDTH; i++)
            line.add(Color.GREY, GRID_HEIGHT - 1);

        lines.add(line);
    }

    /**
     * set the grid tetriminos
     *
     * @param tetriminos new tetriminos
     */
    @Override
    public void setTetriminos(Tetriminos tetriminos) {
        this.tetriminos = tetriminos;
    }

    /**
     * draw the sprite in the screen
     *
     * @param g graphics
     */
    @Override
    public void draw(Graphics g) {
        for (Line line : lines)
            line.draw(g);
    }

    /**
     * get the value at a specific cell
     *
     * @param row the row to check
     *
     * @param column the column to check
     *
     * @return the cell's value at [row][col]
     */
    public int get(int row, int column) {
        return lines.get(row).get(column).getValue();
    }

    /**
     * set the value at a specific cell
     *
     * @param row the row to check
     *
     * @param column the column to check
     *
     * @param value the new value.
     */
    @Override
    public void set(int row, int column, int value) {
        lines.get(row).get(column).setValue(value);
    }

    /**
     * Check if the container is full
     *
     * @return <code>true</code> if it is full else <code>false</code>
     */
    @Override
    public boolean isFull() {
        return lines.get(1).getLineList().stream().filter(cell -> cell.getValue() < 2).count() < 3;
    }

    /**
     * Update method, called at each frame
     */
    @Override
    public void update() {
        if (tetriminos.isPlaced()) {
            removeFullLines();
        }
    }

    /**
     * Removes all lines full.
     */
    private void removeFullLines() {
        for (int i = 0; i < GRID_HEIGHT; i++) {
            if (i == 0 || i == GRID_HEIGHT - 1) continue;
            if (lines.get(i).isFull()) {
                if (!tetris(i)) Player.getInstance().setScore(Player.getInstance().getScore() + 100);
                lines.remove(i--);
                Line line = new Line(1);
                lines.add(1, line);
            }
        } setLinesRow();
    }

    /**
     * set the line index
     */
    private void setLinesRow() {
        for (int i = 0; i < GRID_HEIGHT; i++)
            lines.get(i).setRow(i);
    }

    /**
     * look if a tetris move exists.
     *
     * @param index index to start the check
     *
     * @return <code>true</code> if there's a tetris move, else <code>false</code>
     */
    @Override
    public boolean tetris(int index) {
        if (index + 3 >= GRID_HEIGHT - 1) return false;
        for (int i = 0; i < 4; i++)
            if (!lines.get(index + i).isFull())
                return false;
        return true;
    }

    /**
     * look if a tetris move exists.
     *
     * @return <code>true</code> if there's a tetris move, else <code>false</code>
     */
    @Override
    public boolean tetris() {
        for (int i = 1; i < GRID_HEIGHT; i++)
            if (tetris(i))
                return true;
        return false;
    }
}
