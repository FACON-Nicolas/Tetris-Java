package faconnicolas.project.tetris.grid;

import faconnicolas.project.tetris.color.Color;
import faconnicolas.project.tetris.window.Drawable;

import java.awt.*;
import java.util.ArrayList;

public class Grid implements Drawable {

    public static final int GRID_WIDTH = 11;
    public static final int GRID_HEIGHT = 22;

    /**
     * grid lines' container
     */
    private final ArrayList<Line> lines = new ArrayList<>();

    public Grid() {
        initGrid();
    }

    public void initGrid() {
        Line line = new Line();
        for (int i = 0; i < GRID_WIDTH; i++)
            line.add(Color.GREY, 0);

        lines.add(line);

        for (int i = 1; i < GRID_HEIGHT - 1; i++)
            lines.add(new Line(i));

        line = new Line();
        for (int i = 0; i < GRID_WIDTH; i++)
            line.add(Color.GREY, GRID_HEIGHT - 1);

        lines.add(line);
    }

    /**
     * draw the sprite in the screen
     *
     * @param g graphics
     */
    @Override
    public void draw(Graphics g) {
        for (Line line : lines)
            line.draw(g);
    }
}
