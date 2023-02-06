package faconnicolas.project.tetris.model.tetriminos;

import faconnicolas.project.tetris.model.grid.GridPositionable;

/**
 * Tetriminos class, used to implement tetriminos. (obviously)
 */
public class Tetriminos implements ITetriminos, GridPositionable {

    /**
     * tetriminos array
     */
    private int[][] tetriminosArray;

    /**
     * row attribute
     */
    private int row;

    /**
     * Column attribute
     */
    private int column;

    /**
     * Tetriminos constructor, init the tetriminos according to a string value.
     *
     * @param value the string value.
     */
    public Tetriminos(String value) {
        initTetriminos(value);
        row = 0;
        column = 5;
    }

    /**
     * init tetriminos, called in the constructor.
     *
     * @param value the value to get the tetriminos.
     */
    private void initTetriminos(String value) {
        tetriminosArray = switch(value.toUpperCase()) {
            case "T" -> TetriminosFactory.getT();
            case "S" -> TetriminosFactory.getS();
            case "Z" -> TetriminosFactory.getZ();
            case "O" -> TetriminosFactory.getO();
            case "L" -> TetriminosFactory.getL();
            case "J" -> TetriminosFactory.getJ();
            case "I" -> TetriminosFactory.getI();
            default -> throw new IllegalArgumentException("No tetriminos for " + value);
        };
    }

    /**
     * Rotate the Tetriminos.
     * <p>
     * [ 0 0 1 ] -> [ 0 0 0 ]
     * <p>
     * [ 0 0 0 ] -> [ 0 0 0 ]
     * <p>
     * [ 0 0 0 ] -> [ 0 0 1 ]
     */
    @Override
    public void rotate() {
        int[][] copy = new int[tetriminosArray.length][tetriminosArray.length];
        for (int i = 0; i < length(); i++)
            for (int j = 0; j < length(); j++)
                copy[j][length() - (i+1)] = tetriminosArray[i][j];
        tetriminosArray = copy;
    }


    /**
     * get the length
     *
     * @return the length
     */
    @Override
    public int length() {
        return tetriminosArray.length;
    }

    /**
     * Gets value at a specific place.
     * <p>
     * @param row the row to check
     *
     * @param col the column to check
     *
     * @return the value
     */
    public int get(int row, int col) {
        return tetriminosArray[row][col];
    }

    /**
     * get current row
     *
     * @return current row
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * get current column
     *
     * @return current column
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * set current row
     *
     * @param row new row
     */
    @Override
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * set current column
     *
     * @param column new column
     */
    @Override
    public void setColumn(int column) {
        this.column = column;
    }
}
