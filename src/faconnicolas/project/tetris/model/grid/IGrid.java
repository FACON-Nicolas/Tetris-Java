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

}
