package faconnicolas.project.tetris.controller;

import faconnicolas.project.tetris.model.grid.Grid;
import faconnicolas.project.tetris.model.tetriminos.GridTetriminosMerger;
import faconnicolas.project.tetris.model.tetriminos.Tetriminos;
import faconnicolas.project.tetris.model.tetriminos.TetriminosFactory;
import faconnicolas.project.tetris.model.tetriminos.TetriminosManager;
import faconnicolas.project.tetris.model.window.Updatable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel is the controller in the game.
 */
public class Panel extends JPanel implements ActionListener, Updatable {

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

    private TetriminosManager tetriminos;

    /**
     * panel constructor, init panel and grid.
     */
    public Panel() {
        super();
        setFocusable(true);
        timer = new Timer(DELAY, this);
        timer.start();
        grid = new GridTetriminosMerger(new Grid());
        tetriminos = new TetriminosManager(grid);
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
}
