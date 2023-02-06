package faconnicolas.project.tetris.color;

/**
 * This class is created to add colors in my project.
 * <p>
 * To make easier the color management, I only used the color I need for this game.
 */
public enum Color {

    /**
     * red color
     */
    RED(java.awt.Color.RED),

    /**
     * cyan color
     */
    CYAN(java.awt.Color.CYAN),

    /**
     * blue color
     */
    BLUE(java.awt.Color.BLUE),

    /**
     * yellow color
     */
    YELLOW(java.awt.Color.YELLOW),

    /**
     * orange color
     */
    ORANGE(java.awt.Color.ORANGE),

    /**
     * purple color
     */
    PURPLE(new java.awt.Color(102, 0, 153)),

    /**
     * green color
     */
    GREEN(java.awt.Color.GREEN),

    /**
     * grey color
     */
    GREY(new java.awt.Color(127, 127, 127)),

    /**
     * black color
     */
    BLACK(java.awt.Color.BLACK);


    /**
     * Color attribute, from java.awt.Color class
     */
    final java.awt.Color color;


    /**
     * Color constructor, init the color
     *
     * @param color color
     */
    Color(java.awt.Color color) {
        this.color = color;
    }

    /**
     * @return return color according to Java Color class
     */
    public java.awt.Color getColor() {
        return color;
    }
}
