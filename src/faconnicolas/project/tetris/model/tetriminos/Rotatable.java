package faconnicolas.project.tetris.model.tetriminos;

public interface Rotatable {

    /**
     * Rotate the Tetriminos.
     *<p>
     * 0 0 1    0 0 0
     * 0 0 0 -> 0 0 0
     * 0 0 0    0 0 1
     *
     */
    void rotate();

}
