package faconnicolas.project.tetris.model.grid;

import faconnicolas.project.tetris.model.tetriminos.Tetriminos;
import faconnicolas.project.tetris.model.window.Updatable;
import faconnicolas.project.tetris.view.Drawable;

/**
 * IGrid is an interface to implements the grids.
 */
public interface IGrid extends Gettable, Settable, Drawable, Fillable, Updatable {

    /**
     * init the grid.
     */
    void initGrid();

    /**
     * set the grid tetriminos
     *
     * @param tetriminos new tetriminos
     */
    void setTetriminos(Tetriminos tetriminos);

    /**
     * look if a tetris move exists.
     *
     * @param index index to start the check
     *
     * @return <code>true</code> if there's a tetris move, else <code>false</code>
     */
    boolean tetris(int index);

    /**
     * look if a tetris move exists.
     *
     * @return <code>true</code> if there's a tetris move, else <code>false</code>
     */
    boolean tetris();

}
