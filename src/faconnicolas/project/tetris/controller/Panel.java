package faconnicolas.project.tetris.controller;

import faconnicolas.project.tetris.model.grid.Grid;
import faconnicolas.project.tetris.model.tetriminos.GridTetriminosMerger;
import faconnicolas.project.tetris.model.tetriminos.TetriminosManager;
import faconnicolas.project.tetris.model.window.Updatable;

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

    private final TetriminosManager tetriminos;

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
        grid = new GridTetriminosMerger(new Grid());
        tetriminos = new TetriminosManager(grid, this);
    }

    /**
     * called at each frame
     *
     * @param actionEvent none
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        update();
        tetriminos.update();
    }

    /**
     * paint every component in the game.
     *
     * @param g graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.draw(getGraphics());
    }

    /**
     * Update method, called at each frame
     */
    @Override
    public void update() {
        grid.draw(getGraphics());
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
