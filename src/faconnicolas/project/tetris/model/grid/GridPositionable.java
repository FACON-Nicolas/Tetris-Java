package faconnicolas.project.tetris.model.grid;

/**
 * Grid positionable is an interface to implements row and column
 */
public interface GridPositionable {

    /**
     * get current row
     *
     * @return current row
     */
    int getRow();

    /**
     * get current column
     *
     * @return current column
     */
    int getColumn();

    /**
     * set current row
     *
     * @param row new row
     */
    void setRow(int row);

    /**
     * set current column
     *
     * @param column new column
     */
    void setColumn(int column);

}
