package faconnicolas.project.tetris.model.grid;

import faconnicolas.project.tetris.model.color.Color;
import faconnicolas.project.tetris.model.color.ColorUtil;
import faconnicolas.project.tetris.view.Drawable;
import faconnicolas.project.tetris.view.Window;

import java.awt.*;

/**
 * Cell class, Used to get cells in our tetris grid.
 */
public class Cell implements ICell, Drawable {

    /**
     * Cell value
     */
    private int value;

    /**
     * row attribute.
     */
    private int row;

    /**
     * column attribute.
     */
    private int column;


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
     * Init cell and gives the value thanks to the color
     *
     * @param color color value
     *
     * @param row row for the cell
     *
     * @param column column for the cell
     */
    public Cell(Color color, int row, int column) {
        this(ColorUtil.getValueFromColor(color), row, column);
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
    @Override
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * set column
     *
     * @param column new column
     */
    @Override
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
        return ColorUtil.getColor(value);
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

    /**
     * sets the value
     *
     * @param value new value for the value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * draw the sprite in the screen
     *
     * @param g graphics
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor().getColor());
        g.fillRect(getX(), getY(), Window.CASE_SIZE - 1, Window.CASE_SIZE - 1);
    }
}
