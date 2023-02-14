package faconnicolas.project.tetris.controller;

import faconnicolas.project.tetris.Tetris;
import faconnicolas.project.tetris.model.grid.Grid;
import faconnicolas.project.tetris.model.player.Player;
import faconnicolas.project.tetris.model.tetriminos.GridTetriminosMerger;
import faconnicolas.project.tetris.model.tetriminos.TetriminosManager;
import faconnicolas.project.tetris.model.window.Updatable;
import faconnicolas.project.tetris.view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * Panel is the controller in the game.
 */
public class Panel extends JPanel implements ActionListener, Updatable, KeyListener {

    /**
     * game grid
     */
    private final GridTetriminosMerger grid;

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
    private final TetriminosManager tetriminos;

    /**
     * game over boolean
     */
    private boolean isOver = false;

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
    }

    /**
     * called at each frame
     *
     * @param actionEvent none
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        tetriminos.update();
        update();
    }

    /**
     * paint every component in the game.
     *
     * @param g graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        setBackground(Color.white);
    }

    /**
     * Update method, called at each frame
     */
    @Override
    public void update() {
        getGraphics().setColor(Color.WHITE);
        grid.draw(getGraphics());
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(750, 375, 400, 200);
        g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 3F));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Name: " + Player.getInstance().getName(), 800, 425);
        g2d.drawString("Score: " + Player.getInstance().getScore(), 800, 475);
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
        switch (keyEvent.getKeyCode()) {
            case VK_DOWN -> tetriminos.down();
            case VK_RIGHT -> tetriminos.right();
            case VK_LEFT -> tetriminos.left();
            case VK_SPACE -> tetriminos.place();
            case VK_UP -> tetriminos.rotate();
        }
    }

    /**
     * Key released event.
     *
     * @param keyEvent .
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        // do nothing
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
}
