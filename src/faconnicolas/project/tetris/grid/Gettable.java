package faconnicolas.project.tetris.grid;

public interface Gettable {

    /**
     * Gets value at a specific place.
     * <p>
     * @param row the row to check
     *
     * @param col the column to check
     *
     * @return the value
     */
    int get(int row, int col);
}
