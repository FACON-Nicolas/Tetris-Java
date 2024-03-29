package faconnicolas.project.tetris.controller;

import faconnicolas.project.tetris.Tetris;
import faconnicolas.project.tetris.controller.gamestate.IGameState;
import faconnicolas.project.tetris.controller.gamestate.RunningGameState;
import faconnicolas.project.tetris.model.grid.Grid;
import faconnicolas.project.tetris.model.player.Player;
import faconnicolas.project.tetris.model.tetriminos.GridTetriminosMerger;
import faconnicolas.project.tetris.model.tetriminos.TetriminosManager;
import faconnicolas.project.tetris.model.window.Updatable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


/**
 * Panel is the controller in the game.
 */
public class Panel extends JPanel implements ActionListener, Updatable, KeyListener {

    /**
     * game grid
     */
    private GridTetriminosMerger grid;

    /**
     * timer for each frame.
     */
    private final Timer timer;

    /**
     * delay between each frame (in millis)
     */
    public static final int DELAY = 16;

    /**
     * Tetriminos Manager
     */
    private TetriminosManager tetriminos;

    /**
     * game over boolean
     */
    private boolean isOver = false;

    private final java.util.List<Integer> keys = new ArrayList<>();

    private IGameState gameState;

    /**
     * panel constructor, init panel and grid.
     */
    public Panel() {
        super();
        super.setFocusable(true);
        addKeyListener(this);
        timer = new Timer(DELAY, this);
        timer.start();
        grid = new GridTetriminosMerger(new Grid(null));
        tetriminos = new TetriminosManager(grid, this);
        grid.setTetriminos(tetriminos.getTetriminos());
        Player.getInstance().setGrid(grid);
        gameState = new RunningGameState(this);
    }

    /**
     * called at each frame
     *
     * @param actionEvent none
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gameState.update();
    }

    /**
     * Update method, called at each frame
     */
    @Override
    public void update() {
        setBackground(Color.white);
        grid.draw(getGraphics());
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setColor(Color.white);
        g2d.fillRect(150, 375, 400, 200);
        g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 3F));
        g2d.setColor(Color.BLACK);
        g2d.drawString("Name: " + Player.getInstance().getName(), 200, 425);
        g2d.drawString("Score: " + Player.getInstance().getScore(), 200, 475);
    }

    /**
     * key typed event.
     *
     * @param keyEvent .
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // do nothing
    }

    /**
     * key pressed event.
     *
     * @param keyEvent .
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        gameState.keyPressed(keyEvent);
    }

    /**
     * Key released event.
     *
     * @param keyEvent .
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys.remove((Integer) keyEvent.getKeyCode());
    }

    /**
     * check if the game is over
     *
     * @return over
     */
    public boolean isOver() {
        return isOver;
    }

    /**
     * set over to true, the game is over.
     */
    public void setOver() {
        isOver = true;
    }

    /**
     * getter for tetriminos manager
     *
     * @return tetriminos manager
     */
    public TetriminosManager getTetriminos() {
        return tetriminos;
    }

    /**
     * getter for keys
     *
     * @return keys
     */
    public java.util.List<Integer> getKeys() {
        return keys;
    }

    /**
     * setter for game state
     *
     * @param gameState new game state
     */
    public void setGameState(IGameState gameState) {
        this.gameState = gameState;
    }

    /**
     * reset the controller
     */
    public void reset() {
        isOver = false;
        Player.getInstance().setScore(0);
        Graphics g = getGraphics();
        g.clearRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
        grid = new GridTetriminosMerger(new Grid(null));
        tetriminos = new TetriminosManager(grid, this);
        grid.setTetriminos(tetriminos.getTetriminos());
        Player.getInstance().setGrid(grid);
        gameState = new RunningGameState(this);
    }
}
