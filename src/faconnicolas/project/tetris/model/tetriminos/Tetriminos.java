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
     * isPlaced attribute.
     */
    private boolean isPlaced = false;

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
        int[][] copy = new int[width()][height()];
        for (int i = 0; i < height(); i++)
            for (int j = 0; j < width(); j++)
                copy[j][height() - (i+1)] = tetriminosArray[i][j];
        tetriminosArray = copy;
    }

    /**
     * get the width
     *
     * @return the width
     */
    @Override
    public int width() {
        return tetriminosArray[0].length;
    }


    /**
     * get the height
     *
     * @return the height
     */
    @Override
    public int height() {
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

    /**
     * get isPlaced.
     *
     * @return <code>true</code> if the tetriminos is placed else <code>false</code>.
     */
    public boolean isPlaced() {
        return isPlaced;
    }

    /**
     * set isPlaced.
     *
     * @param placed new placed value.
     */
    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }
}
