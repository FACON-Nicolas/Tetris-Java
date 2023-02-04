package faconnicolas.project.tetris.color;

/**
 * ColorFactory is a class that gives colors and
 * specific color according the value given.
 */
public class ColorFactory implements Colorable {

    /**
     * value used to get the color
     */
    private int value;

    /**
     * get blue color
     *
     * @return blue color
     */
    public static Color getBlue() {
        return Color.BLUE;
    }

    /**
     * get red color
     *
     * @return red color
     */
    public static Color getRed() {
        return Color.RED;
    }

    /**
     * get yellow color
     *
     * @return yellow color
     */
    public static Color getYellow() {
        return Color.YELLOW;
    }

    /**
     * get cyan color
     *
     * @return cyan color
     */
    public static Color getCyan() {
        return Color.CYAN;
    }

    /**
     * get purple color
     *
     * @return purple color
     */
    public static Color getPurple() {
        return Color.PURPLE;
    }

    /**
     * get orange color
     *
     * @return orange color
     */
    public static Color getOrange() {
        return Color.ORANGE;
    }

    /**
     * get green color
     *
     * @return green
     */
    public static Color getGreen() {
        return Color.GREEN;
    }

    /**
     * get grey color
     *
     * @return grey color
     */
    public static Color getGrey() {
        return Color.GREY;
    }

    /**
     * get black color
     *
     * @return black color
     */
    private static Color getBlack() { return Color.BLACK; }

    /**
     * get color according a value given in parameter.
     * 0 -> Black
     * 1 -> Grey
     * 2 -> Cyan
     * 3 -> Yellow
     * 4 -> Purple
     * 5 -> Blue
     * 6 -> Orange
     * 7 -> Red
     * 8 -> Green
     * else -> UnsupportedOperationException
     *
     * @param value the value given
     *
     * @return color
     */
    public static Color getColor(int value) {
        return switch(value) {
            case 0 -> getBlack();
            case 1 -> getGrey();
            case 2 -> getCyan();
            case 3 -> getYellow();
            case 4 -> getPurple();
            case 5 -> getBlue();
            case 6 -> getOrange();
            case 7 -> getRed();
            case 8 -> getGreen();
            default -> throw new UnsupportedOperationException("No color for " + value + " value.");
        };
    }

    /**
     * get the color according to value in the factory
     *
     * @see ColorFactory#getColor(int)
     *
     * @return color according to value
     */
    @Override
    public Color getColor() {
        return getColor(value);
    }
}
