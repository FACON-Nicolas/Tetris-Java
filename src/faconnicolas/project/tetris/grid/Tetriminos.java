package faconnicolas.project.tetris.grid;

import java.util.Random;

public class Tetriminos implements ITetriminos, GridPositionable {

    private int[][] tetriminos;

    private int row, column;

    public Tetriminos(String value) {
        initTetriminos(value);
        row = 0;
        //column = new Random().nextInt(0, Grid.GRID_WIDTH-length());
        column = 5;
    }

    private void initTetriminos(String value) {
        tetriminos = switch(value.toUpperCase()) {
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
        int[][] copy = new int[tetriminos.length][tetriminos.length];
        for (int i = 0; i < length(); i++)
            for (int j = 0; j < length(); j++)
                copy[j][length() - (i+1)] = tetriminos[i][j];
        tetriminos = copy;
    }

    @Override
    public int length() {
        return tetriminos.length;
    }

    public int get(int row, int col) {
        return tetriminos[row][col];
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }
}
