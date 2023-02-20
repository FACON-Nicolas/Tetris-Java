package faconnicolas.project.tetris.model.tetriminos;

import faconnicolas.project.tetris.controller.Panel;
import faconnicolas.project.tetris.controller.gamestate.GameOverGameState;
import faconnicolas.project.tetris.model.color.ColorUtil;
import faconnicolas.project.tetris.model.player.Player;
import faconnicolas.project.tetris.model.window.Updatable;
import faconnicolas.project.tetris.view.Drawable;
import faconnicolas.project.tetris.view.Window;

import java.awt.*;

/**
 * TetriminosManager class is used to manage spawn and update on tetriminos
 */
public class TetriminosManager implements ITetriminosMovable, Updatable, Drawable {

    /**
     * grid
     */
    private GridTetriminosMerger grid;

    /**
     * tetriminos
     */
    private Tetriminos tetriminos;

    /**
     * next tetriminos
     */
    private Tetriminos next;

    /**
     * proxy
     */
    private final ITetriminosMovable proxy;

    /**
     * controller
     */
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
        this.next = new Tetriminos(TetriminosFactory.randomTetriminos());
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
        grid.setTetriminos(getTetriminos());
        next = new Tetriminos(TetriminosFactory.randomTetriminos());
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
        if (!panel.isOver()) {
            moveDownTetriminos();
            checkTetriminos();
        }
    }

    /**
     * manage move down.
     * <p>
     * if the tetriminos is placed vertically, then a new is created.
     */
    public void moveDownTetriminos() {
        if (System.currentTimeMillis() - time >= 500) {
            Player.getInstance().increment(tetriminos.getValue());
            time = System.currentTimeMillis();
            down();
        }
    }

    /**
     * check tetriminos movement and update it if it has to do it.
     */
    public void checkTetriminos() {
        if (tetriminos.isPlaced() && !grid.isFull()) {
            Player.getInstance().update();
            grid.update();
            setTetriminos(next);
            Graphics g = panel.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(1200, 500, 200, 200);
        } else if (tetriminos.isPlaced() && grid.isFull()) panel.setOver();
    }

    /**
     * place the tetriminos directly
     */
    public void place() {
        while (!tetriminos.isPlaced()) down();
        time = 0;
    }

    /**
     * draw the sprite in the screen
     *
     * @param g graphics
     */
    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < next.height(); i++) {
            for (int j = 0; j < next.width(); j++) {
                g.setColor(ColorUtil.getColor(next.get(i, j)).getColor());
                g.fillRect(1200+(
                        j * Window.CASE_SIZE),
                        400 + (i * Window.CASE_SIZE),
                        Window.CASE_SIZE-1,
                        Window.CASE_SIZE-1
                );
            }
        }
    }
}
