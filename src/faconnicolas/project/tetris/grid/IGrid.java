package faconnicolas.project.tetris.grid;

import faconnicolas.project.tetris.window.Drawable;

/**
 * IGrid is an interface to implements the grids.
 */
public interface IGrid extends Gettable, Settable, Drawable {

    /**
     * init the grid.
     */
    void initGrid();

}
