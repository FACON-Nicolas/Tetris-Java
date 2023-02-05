package faconnicolas.project.tetris.grid;

public class GridTetriminosMerger extends GridDecorator {

    public GridTetriminosMerger(IGrid grid) {
        super(grid);
    }

    public boolean canMarge(Tetriminos tetriminos) {
        int row = tetriminos.getRow();
        int column = tetriminos.getColumn();
        if (column >= Grid.GRID_WIDTH - (1+ tetriminos.length()) || row >= Grid.GRID_HEIGHT - 1) return false;
        for (int i = row; i > 1 || (tetriminos.getRow() - i) < tetriminos.length(); i--) {
            for (int j = column; j - tetriminos.getColumn() < tetriminos.length(); j++) {
                if (tetriminos.get(tetriminos.getRow() - i, j - column) != 0 && grid.get(i, j) != 0)
                    return false;
            }
        }
        return true;
    }

    public void merge(Tetriminos tetriminos) {
        if (!canMarge(tetriminos)) return;
        int row = tetriminos.getRow();
        int column = tetriminos.getColumn();
        for (int i = row; i > 1 || (row - i) < tetriminos.length(); i--) {
            for (int j = column; j - column < tetriminos.length(); j++) {
                set(i, j, tetriminos.get(row - i, j - column));
            }
        }

        for (int i = 0; i < Grid.GRID_HEIGHT; i++) {
            for (int j = 0; j < Grid.GRID_WIDTH; j++)
                System.out.print(get(i, j) + " ");
            System.out.println();
        }
    }

    public void erase(Tetriminos tetriminos) {
        int row = tetriminos.getRow();
        int column = tetriminos.getColumn();
        if (column >= Grid.GRID_WIDTH - (1+ tetriminos.length()) || row >= Grid.GRID_HEIGHT - 1) return;
        for (int i = row; i > 1 || (row - i) < tetriminos.length(); i--) {
            for (int j = column; j - column < tetriminos.length(); j++) {
                int r = row - i; // r is for row
                int c = j - column; // c is for column
                if (grid.get(i, j) != 0 && tetriminos.get(r, c) != 0) grid.set(i, j, 0);
            }
        }
    }

}
