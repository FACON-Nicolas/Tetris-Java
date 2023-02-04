package faconnicolas.project.tetris.grid;

/**
 * ILine interface, used to define the Tetris' grid's lines.
 */
public interface ILine {

    /**
     * check if the line is full thanks to a lambda expression.
     *
     * @return <code>true</code> if full else <code>false</code>
     */
    boolean isFull();

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
}
