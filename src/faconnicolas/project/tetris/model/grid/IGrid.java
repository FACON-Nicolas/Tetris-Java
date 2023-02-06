package faconnicolas.project.tetris.model.grid;

import faconnicolas.project.tetris.view.Drawable;

/**
 * IGrid is an interface to implements the grids.
 */
public interface IGrid extends Gettable, Settable, Drawable {

    /**
     * init the grid.
     */
    void initGrid();

}
