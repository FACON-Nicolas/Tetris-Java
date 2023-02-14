package faconnicolas.project.tetris.model.grid;

import faconnicolas.project.tetris.model.color.Color;
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

    /**
     * Grid constructor, init grid
     */
    public Grid() {
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
}
