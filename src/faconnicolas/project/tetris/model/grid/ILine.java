package faconnicolas.project.tetris.model.grid;

/**
 * ILine interface, used to define the Tetris' grid's lines.
 */
public interface ILine extends Fillable {

    /**
     * check if the line is empty thanks to a lambda expression.
     *
     * @return <code>true</code> if empty else <code>false</code>
     */
    boolean isEmpty();

    /**
     * get a specific cell positioned at a specific index.
     *
     * @param index the index to check
     *
     * @return the cell
     */
    Cell get(int index);

    /**
     * set a specific cell in index
     *
     * @param index cell's index
     *
     * @param cell new cell
     */
    void set(int index, Cell cell);

    /**
     * set a specific cell's value in index
     *
     * @param index cell's index
     *
     * @param value new cell's value
     */
    void set(int index, int value);
}
