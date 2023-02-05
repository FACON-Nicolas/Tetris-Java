package faconnicolas.project.tetris.grid;

import faconnicolas.project.tetris.window.Drawable;

import java.awt.*;
import java.util.ArrayList;
import faconnicolas.project.tetris.color.Color;

/**
 * Line is here to have lines in my Tetris' grid.
 */
public class Line implements ILine, Drawable {

    /**
     * line's container
     */
    private ArrayList<Cell> line;

    public Line() {
        this.line = new ArrayList<>();
    }

    /**
     * constructor, init line's container.
     */
    public Line(int indexLine) {
        this();
        initLine(indexLine);
    }

    void initLine(int indexLine) {
        line.add(new Cell(Color.GREY, indexLine, 0));
        for (int i = 1; i < Grid.GRID_WIDTH - 1; i++)
            line.add(new Cell(Color.BLACK, indexLine, i));
        line.add(new Cell(Color.GREY, indexLine, Grid.GRID_WIDTH - 1));

    }

    /**
     * check if the line is full thanks to a lambda expression.
     *
     * @return <code>true</code> if full else <code>false</code>
     */
    @Override
    public boolean isFull() {
        return line.stream().noneMatch(cell -> cell.getValue() != 0);
    }

    /**
     * create a line's container copy and returns it.
     *
     * @return a copy fo the line's container.
     */
    public ArrayList<Cell> getLine() {
        return new ArrayList<>(line);
    }

    /**
     * get a specific cell positioned at a specific index.
     *
     * @param index the index to check
     *
     * @return the cell
     */
    @Override
    public Cell get(int index) {
        return line.get(index);
    }

    /**
     * set a specific cell in index
     *
     * @param index cell's index
     *
     * @param cell new cell
     */
    @Override
    public void set(int index, Cell cell) {
        line.set(index, cell);
    }

    /**
     * set a specific cell's value in index
     *
     * @param index cell's index
     * @param value new cell's value
     */
    @Override
    public void set(int index, int value) {
        line.get(index).setValue(value);
    }

    /**
     * draw the sprite in the screen
     *
     * @param g graphics
     */
    @Override
    public void draw(Graphics g) {
        for (Cell cell : line)
            cell.draw(g);
    }

    void add(Color color, int index) {
        line.add(new Cell(color, index, line.size()));
    }
}
