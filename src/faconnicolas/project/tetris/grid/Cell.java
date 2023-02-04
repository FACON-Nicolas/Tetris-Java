package faconnicolas.project.tetris.grid;

import faconnicolas.project.tetris.color.Color;
import faconnicolas.project.tetris.color.ColorFactory;
import faconnicolas.project.tetris.window.Window;

/**
 * Cell class, Used to get cells in our tetris grid.
 */
public class Cell implements ICell {

    /**
     * Cell value
     */
    private int value;

    /**
     * row and column
     */
    private int row, column;


    /**
     * Init a Cell.
     *
     * @param value value for color
     *
     * @param row row for the cell
     *
     * @param column column for the cell
     */
    public Cell(int value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    /**
     * get row
     *
     * @return row
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * get column
     *
     * @return column
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * set row
     *
     * @param row new row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * set column
     *
     * @param column new column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * get Color according to the cell value
     *
     * @return color according the cell value
     */
    @Override
    public Color getColor() {
        return ColorFactory.getColor(value);
    }


    /**
     * get x position
     *
     * @return x position
     */
    @Override
    public int getX() {
        return Window.CASE_SIZE * column;
    }

    /**
     * get Y position
     *
     * @return Y position
     */
    @Override
    public int getY() {
        return Window.CASE_SIZE * row;
    }

    /**
     * get Cell value
     *
     * @return cell value
     */
    public int getValue() {
        return value;
    }
}
