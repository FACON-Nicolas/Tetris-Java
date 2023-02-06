package faconnicolas.project.tetris.grid;

/**
 * as Gettable, Settable is an interface to implement get in the grid.
 */
public interface Settable {

    /**
     * set the cell's at row col position
     *
     * @param row the cell's row
     *
     * @param column the cell's column
     *
     * @param value the new value.
     */
    void set(int row, int column, int value);

}
