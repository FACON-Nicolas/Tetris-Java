package faconnicolas.project.tetris.model.tetriminos;

/**
 * Interface used to implement classes to move a tetriminos
 */
public interface ITetriminosMovable extends Rotatable {

    /**
     * move down the tetriminos
     */
    void down();

    /**
     * move up the tetriminos
     */
    void up();

    /**
     * move right the tetriminos
     */
    void right();

    /**
     * move left the tetriminos
     */
    void left();

    /**
     * set the tetriminos
     *
     * @param tetriminos tetriminos
     */
    void setTetriminos(Tetriminos tetriminos);

    /**
     * set the grid
     *
     * @param grid grid
     */
    void setGrid(GridTetriminosMerger grid);
}
