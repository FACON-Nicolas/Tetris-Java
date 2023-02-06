package faconnicolas.project.tetris.model.tetriminos;

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

    /**
     * get the length
     *
     * @return the length
     */
    int length();

}
