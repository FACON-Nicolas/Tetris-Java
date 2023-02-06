package faconnicolas.project.tetris;

import faconnicolas.project.tetris.view.Window;

import javax.swing.*;

/**
 * main class, used to launch the game
 */
public class Tetris {

    /**
     * width
     */
    public static final int WIDTH = 1600;

    /**
     * height
     */
    public static final int HEIGHT = 915;

    /**
     * window name
     */
    public static final String NAME = "Tetris";

    /**
     * main method.
     *
     * @param args no args.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window(NAME, WIDTH, HEIGHT));
    }
}