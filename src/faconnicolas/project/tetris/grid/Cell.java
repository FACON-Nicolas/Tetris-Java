package faconnicolas.project.tetris.grid;

import faconnicolas.project.tetris.color.Color;
import faconnicolas.project.tetris.color.ColorFactory;
import faconnicolas.project.tetris.window.Window;

public class Cell implements ICell {

    private int value;
    private int row, column;

    public Cell(int value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public Color getColor() {
        return ColorFactory.getColor(value);
    }

    @Override
    public int getX() {
        return Window.CASE_SIZE * column;
    }

    @Override
    public int getY() {
        return Window.CASE_SIZE * row;
    }
}
