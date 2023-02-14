package faconnicolas.project.tetris.model.tetriminos;

/**
 * Tetriminos Proxy is class used to control movements with all constraints in the grid.
 */
public class TetriminosProxy implements ITetriminosMovable {

    /**
     * proxy grid.
     */
    private GridTetriminosMerger grid;

    /**
     * proxy tetriminos
     */
    private Tetriminos tetriminos;

    /**
     * Constructor, create a new proxy.
     *
     * @param grid grid
     *
     * @param tetriminos tetriminos
     */
    public TetriminosProxy(GridTetriminosMerger grid, Tetriminos tetriminos) {
        this.grid = grid;
        this.tetriminos = tetriminos;
    }

    /**
     * move down the tetriminos
     */
    @Override
    public void down() {
        grid.erase(tetriminos);
        tetriminos.setRow(tetriminos.getRow() + 1);
        if (!grid.canMarge(tetriminos)) {
            tetriminos.setRow(tetriminos.getRow() - 1);
            tetriminos.setPlaced(true);
        } grid.merge(tetriminos);
    }

    /**
     * move up the tetriminos
     */
    @Override
    public void up() {
        grid.erase(tetriminos);
        tetriminos.setRow(tetriminos.getRow() - 1);
        if (!grid.canMarge(tetriminos))
            tetriminos.setRow(tetriminos.getRow() + 1);
        grid.merge(tetriminos);
    }

    /**
     * move right the tetriminos
     */
    @Override
    public void right() {
        if (tetriminos.getRow() <= 2) return;
        grid.erase(tetriminos);
        tetriminos.setColumn(tetriminos.getColumn() + 1);
        if (!grid.canMarge(tetriminos))
            tetriminos.setColumn(tetriminos.getColumn() - 1);
        grid.merge(tetriminos);
    }

    /**
     * move left the tetriminos
     */
    @Override
    public void left() {
        if (tetriminos.getRow() <= 2) return;
        grid.erase(tetriminos);
        tetriminos.setColumn(tetriminos.getColumn() - 1);
        if (!grid.canMarge(tetriminos))
            tetriminos.setColumn(tetriminos.getColumn() + 1);
        grid.merge(tetriminos);
    }

    /**
     * set the tetriminos
     *
     * @param tetriminos tetriminos
     */
    @Override
    public void setTetriminos(Tetriminos tetriminos) {
        this.tetriminos = tetriminos;
    }

    /**
     * set the grid
     *
     * @param grid grid
     */
    @Override
    public void setGrid(GridTetriminosMerger grid) {
        this.grid = grid;
    }

    /**
     * Rotate the Tetriminos.
     * <p>
     * 0 0 1    0 0 0
     * 0 0 0 -> 0 0 0
     * 0 0 0    0 0 1
     */
    @Override
    public void rotate() {
        grid.erase(tetriminos);
        tetriminos.rotate();
        if (!grid.canMarge(tetriminos))
            for (int i = 0; i < 3; i++) tetriminos.rotate();
        grid.merge(tetriminos);
    }
}
