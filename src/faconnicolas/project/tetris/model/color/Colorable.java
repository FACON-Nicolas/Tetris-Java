package faconnicolas.project.tetris.model.color;


/**
 * Colorable interface is used on every Tetris'
 * objects using a color, like cell, grid, and another.
 */
@FunctionalInterface
public interface Colorable {

    /**
     * gets Colorable object's color
     * <p>
     * @return Colorable object's color
     */
    Color getColor();
}
