package faconnicolas.project.tetris.model.grid;

import faconnicolas.project.tetris.view.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import faconnicolas.project.tetris.model.color.Color;

/**
 * Line is here to have lines in my Tetris' grid.
 */
public class Line implements ILine, Drawable, GridPositionable {

    /**
     * line's container
     */
    private final List<Cell> lineList;

    public Line() {
        this.lineList = new ArrayList<>();
    }

    /**
     * constructor, init line's container.
     */
    public Line(int indexLine) {
        this();
        initLine(indexLine);
    }

    /**
     * init the line according to the indexLine
     *
     * @param indexLine line's index.
     */
    void initLine(int indexLine) {
        lineList.add(new Cell(Color.GREY, indexLine, 0));
        for (int i = 1; i < Grid.GRID_WIDTH - 1; i++)
            lineList.add(new Cell(Color.BLACK, indexLine, i));
        lineList.add(new Cell(Color.GREY, indexLine, Grid.GRID_WIDTH - 1));

    }

    /**
     * check if the line is full thanks to a lambda expression.
     *
     * @return <code>true</code> if full else <code>false</code>
     */
    @Override
    public boolean isFull() {
        return lineList.stream().noneMatch(cell -> cell.getValue() == 0);
    }

    /**
     * check if the line is empty thanks to a lambda expression.
     *
     * @return <code>true</code> if empty else <code>false</code>
     */
    @Override
    public boolean isEmpty() {
        return lineList.stream().allMatch(cell -> cell.getValue() < 2);
    }

    /**
     * create a line's container copy and returns it.
     *
     * @return a copy fo the line's container.
     */
    public List<Cell> getLineList() {
        return new ArrayList<>(lineList);
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
        return lineList.get(index);
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
        lineList.set(index, cell);
    }

    /**
     * set a specific cell's value in index
     *
     * @param index cell's index
     * @param value new cell's value
     */
    @Override
    public void set(int index, int value) {
        lineList.get(index).setValue(value);
    }

    /**
     * draw the sprite in the screen
     *
     * @param g graphics
     */
    @Override
    public void draw(Graphics g) {
        for (Cell cell : lineList)
            cell.draw(g);
    }

    /**
     * add a value in the grid
     *
     * @param color color associated to the value you want.
     *
     * @param index the new index.
     */
    void add(Color color, int index) {
        lineList.add(new Cell(color, index, lineList.size()));
    }

    /**
     * get current row
     *
     * @return current row
     */
    @Override
    public int getRow() {
        return lineList.get(0).getRow();
    }

    /**
     * get current column
     *
     * @return current column
     */
    @Override
    public int getColumn() {
        throw new UnsupportedOperationException("It is impossible because a line has no column.");
    }

    /**
     * set current row
     *
     * @param row new row
     */
    @Override
    public void setRow(int row) {
        if (getRow() == row) return;
        for (ICell cell : lineList)
            cell.setRow(row);
    }

    /**
     * set current column
     *
     * @param column new column
     */
    @Override
    public void setColumn(int column) {
        throw new UnsupportedOperationException("It is impossible because a line has no column.");
    }
}
