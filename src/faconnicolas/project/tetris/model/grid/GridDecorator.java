package faconnicolas.project.tetris.model.grid;

import faconnicolas.project.tetris.model.tetriminos.Tetriminos;

import java.awt.*;

/**
 * Grid decorator is an abstract class, used to get new features with no modification on the grid class.
 */
public abstract class GridDecorator implements IGrid {

    /**
     * the grid
     */
    protected IGrid grid;

    /**
     * init a Decorator
     *
     * @param grid the decore
     */
    protected GridDecorator(IGrid grid) {
        this.grid = grid;
    }

    /**
     * init grid, useless here because it is called on the grid constructor
     */
    @Override
    public void initGrid() {
        //not used, useless.
    }

    /**
     * get the value in a specific cell in the grid.
     *
     * @param row the row to check
     *
     * @param col the column to check
     *
     * @return the value
     */
    @Override
    public int get(int row, int col) {
        return grid.get(row, col);
    }


    /**
     * set a specific value in the grid.
     *
     * @param row the row
     *
     * @param column the column
     *
     * @param value the new value
     */
    @Override
    public void set(int row, int column, int value) {
        grid.set(row, column, value);
    }

    /**
     * draw the grid.
     *
     * @param g graphics
     */
    @Override
    public void draw(Graphics g) {
        grid.draw(g);
    }

    /**
     * getter for grid
     *
     * @return the grid.
     */
    public IGrid getGrid() {
        return grid;
    }

    /**
     * check if the grid is full
     *
     * @return <code>true</code> if the grid is full else <code>false</code>
     */
    @Override
    public boolean isFull() {
        return grid.isFull();
    }

    /**
     * setter for tetriminos
     *
     * @param tetriminos new tetriminos
     */
    @Override
    public void setTetriminos(Tetriminos tetriminos) {
        grid.setTetriminos(tetriminos);
    }


    /**
     * called each time we need to call it.
     */
    @Override
    public void update() {
        grid.update();
    }
}
