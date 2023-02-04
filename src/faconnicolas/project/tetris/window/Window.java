package faconnicolas.project.tetris.window;

import javax.swing.*;

/**
 * Window class, used to show on the screen everything about the game.
 */
public class Window {

    /**
     * CASE_SIZE is the size for a cell.
     */
    public static final int CASE_SIZE = 40;

    private int width;

    private int height;

    private JFrame window;

    public Window(String name, int width, int height) {
        this.width = width;
        this.height = height;
        initWindow(name);
    }

    private void initWindow(String name) {
        window = new JFrame(name);
        window.setContentPane(new Panel());
        window.setSize(width, height);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);

    }
}
