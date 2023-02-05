package faconnicolas.project.tetris.grid;

public interface ITetriminos {

    /**
     * Rotate the Tetriminos.
     *<p>
     * 0 0 1    0 0 0
     * 0 0 0 -> 0 0 0
     * 0 0 0    0 0 1
     *
     */
    void rotate();

    int length();

}
