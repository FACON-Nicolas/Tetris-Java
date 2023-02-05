package faconnicolas.project.tetris.window;

import faconnicolas.project.tetris.grid.Grid;
import faconnicolas.project.tetris.grid.GridTetriminosMerger;
import faconnicolas.project.tetris.grid.IGrid;
import faconnicolas.project.tetris.grid.Tetriminos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener, Updatable {

    private final GridTetriminosMerger grid;

    private final Timer timer;

    public static final int DELAY = 16;

    public Panel() {
        super();
        setFocusable(true);
        timer = new Timer(DELAY, this);
        timer.start();
        grid = new GridTetriminosMerger(new Grid());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        update();
    }

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
