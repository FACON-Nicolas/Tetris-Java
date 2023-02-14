package faconnicolas.project.tetris.view;

import faconnicolas.project.tetris.controller.Panel;

import javax.swing.*;

/**
 * Window class, used to show on the screen everything about the game.
 */
public class Window {

    /**
     * CASE_SIZE is the size for a cell.
     */
    public static final int CASE_SIZE = 40;

    /**
     * window width
     */
    private final int width;

    /**
     * window height
     */
    private final int height;

    /**
     * window
     */
    private final JFrame tetrisWindow;

    /**
     * init game window.
     *
     * @param name window name
     *
     * @param width window width
     *
     * @param height window height
     */
    public Window(String name, int width, int height) {
        this.width = width;
        this.height = height;
        tetrisWindow = new JFrame(name);
        initWindow();
    }

    /**
     * init window, called in the constructor.
     */
    private void initWindow() {
        Panel panel = new Panel();
        tetrisWindow.setContentPane(panel);
        tetrisWindow.addKeyListener(panel);
        tetrisWindow.setSize(width, height);
        tetrisWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tetrisWindow.setResizable(false);
        tetrisWindow.setVisible(true);
    }
}
