package faconnicolas.project.tetris.model.tetriminos;

import faconnicolas.project.tetris.controller.Panel;
import faconnicolas.project.tetris.model.window.Updatable;

/**
 * TetriminosManager class is used to manage spawn and update on tetriminos
 */
public class TetriminosManager implements ITetriminosMovable, Updatable {

    /**
     * grid
     */
    private GridTetriminosMerger grid;

    /**
     * tetriminos
     */
    private Tetriminos tetriminos;

    /**
     * proxy
     */
    private final ITetriminosMovable proxy;

    private final Panel panel;

    /**
     * time for manager, manages move down automatically.
     */
    private long time;


    /**
     * TetriminosManager constructor.
     *
     * @param grid grid
     *
     */
    public TetriminosManager(GridTetriminosMerger grid, Panel panel) {
        this.grid = grid;
        this.tetriminos = new Tetriminos(TetriminosFactory.randomTetriminos());
        this.proxy = new TetriminosProxy(grid, tetriminos);
        this.panel = panel;
        time = System.currentTimeMillis();
    }

    /**
     * move down the tetriminos
     */
    @Override
    public void down() {
        proxy.down();
    }

    /**
     * move up the tetriminos
     */
    @Override
    public void up() {
        proxy.up();
    }

    /**
     * move right the tetriminos
     */
    @Override
    public void right() {
        proxy.right();
    }

    /**
     * move left the tetriminos
     */
    @Override
    public void left() {
        proxy.left();
    }

    /**
     * set the tetriminos
     *
     * @param tetriminos tetriminos
     */
    @Override
    public void setTetriminos(Tetriminos tetriminos) {
        this.tetriminos = tetriminos;
        proxy.setTetriminos(getTetriminos());
    }

    /**
     * set the grid
     *
     * @param grid grid
     */
    @Override
    public void setGrid(GridTetriminosMerger grid) {
        this.grid = grid;
        proxy.setGrid(getGrid());
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
        proxy.rotate();
    }

    /**
     * Getter for grid
     *
     * @return grid
     */
    public GridTetriminosMerger getGrid() {
        return grid;
    }

    /**
     * Getter for tetriminos
     *
     * @return tetriminos
     */
    public Tetriminos getTetriminos() {
        return tetriminos;
    }

    /**
     * Update method, called at each frame
     */
    @Override
    public void update() {
        if (!panel.isOver()) moveDownTetriminos();
    }

    /**
     * manage move down.
     * <p>
     * if the tetriminos is placed vertically, then a new is created.
     */
    public void moveDownTetriminos() {
        if (System.currentTimeMillis() - time >= 500) {
            time = System.currentTimeMillis();
            down();
            if (tetriminos.isPlaced() && !grid.isFull())
                setTetriminos(new Tetriminos(TetriminosFactory.randomTetriminos()));
            else if (grid.isFull()) panel.setOver();
        }
    }

    /**
     * place the tetriminos directly
     */
    public void place() {
        while (!tetriminos.isPlaced()) down();
        time = 0;
    }
}
