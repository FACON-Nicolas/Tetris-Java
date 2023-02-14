package faconnicolas.project.tetris.model.tetriminos;

import faconnicolas.project.tetris.model.grid.Grid;
import faconnicolas.project.tetris.model.grid.GridDecorator;
import faconnicolas.project.tetris.model.grid.IGrid;

/**
 * Decorator used to merge tetriminos with the grid.
 */
public class GridTetriminosMerger extends GridDecorator {

    /**
     * init the decorator
     *
     * @param grid decore
     */
    public GridTetriminosMerger(IGrid grid) {
        super(grid);
    }

    /**
     * check if it is possible to merge the grid with the tetriminos
     *
     * @param tetriminos the tetriminos to "merge"
     *
     * @return <code>true</code> if it is possible else <code>false</code>.
     */
    public boolean canMarge(Tetriminos tetriminos) {
        int row = tetriminos.getRow();
        int column = tetriminos.getColumn();
        if (column > Grid.GRID_WIDTH - (tetriminos.width()) || row >= Grid.GRID_HEIGHT) return false;
        for (int i = row; i >= 1 && (tetriminos.getRow() - i) < tetriminos.height(); i--)
            for (int j = column; j - tetriminos.getColumn() < tetriminos.width(); j++)
                if (tetriminos.get(row - i, j - column) != 0 && get(i, j) != 0)
                    return false;
        return true;
    }

    /**
     * merge tetriminos with grid
     *
     * @param tetriminos tetriminos to merge
     */
    public void merge(Tetriminos tetriminos) {
        if (!canMarge(tetriminos)) return;
        int row = tetriminos.getRow();
        int column = tetriminos.getColumn();
        for (int i = row; i >= 1 && (row - i) < tetriminos.height(); i--)
            for (int j = column; j - column < tetriminos.width(); j++)
                if (tetriminos.get(row - i, j - column) != 0)
                    set(i, j, tetriminos.get(row - i, j - column));
    }

    /**
     * erase tetriminos from the grid.
     *
     * @param tetriminos tetriminos to erase
     */
    public void erase(Tetriminos tetriminos) {
        int row = tetriminos.getRow();
        int column = tetriminos.getColumn();
        if (column > Grid.GRID_WIDTH - (tetriminos.width()) || row >= Grid.GRID_HEIGHT) return;
        for (int i = row; i >= 1 && (row - i) < tetriminos.height(); i--) {
            for (int j = column; j - column < tetriminos.width(); j++) {
                int r = row - i; // r is for row
                int c = j - column; // c is for column
                if (get(i, j) != 0 && tetriminos.get(r, c) != 0) set(i, j, 0);
            }
        }
    }

}
