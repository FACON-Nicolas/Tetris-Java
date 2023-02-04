package faconnicolas.project.tetris;

import faconnicolas.project.tetris.window.Window;

import javax.swing.*;

public class Tetris {

    public static final int WIDTH = 1600;
    public static final int HEIGHT = 915;
    public static final String NAME = "Tetris";
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window(NAME, WIDTH, HEIGHT));
    }
}