package faconnicolas.project.tetris.grid;

import faconnicolas.project.tetris.window.Drawable;

import java.awt.*;

public abstract class GridDecorator implements IGrid {

    protected IGrid grid;

    protected GridDecorator(IGrid grid) {
        this.grid = grid;
    }

    @Override
    public void initGrid() {
        //not used, useless.
    }

    @Override
    public int get(int row, int col) {
        return grid.get(row, col);
    }

    @Override
    public void set(int row, int column, int value) {
        grid.set(row, column, value);
    }

    @Override
    public void draw(Graphics g) {
        grid.draw(g);
    }

    public IGrid getGrid() {
        return grid;
    }
}
