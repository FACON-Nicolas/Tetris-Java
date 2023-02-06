package faconnicolas.project.tetris.model.color;

/**
 * ColorFactory is a class that gives colors and
 * specific color according the value given.
 */
public class ColorUtil {

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
     * <p>
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
     * from a color gives the value (reverse of ColorFactory#getColor())
     * <p>
     * Black -> 0
     * Grey -> 1
     * Cyan -> 2
     * Yellow -> 3
     * Purple -> 4
     * Blue -> 5
     * Orange -> 6
     * Red -> 7
     * Green -> 8
     * 
     * @see ColorUtil#getValueFromColor(Color)
     *
     * @param color the color associated to the value.
     *
     * @return the value associated to the color.
     */
    public static int getValueFromColor(Color color) {
        return switch(color) {
            case BLACK -> 0;
            case GREY -> 1;
            case CYAN -> 2;
            case YELLOW -> 3;
            case PURPLE -> 4;
            case BLUE -> 5;
            case ORANGE -> 6;
            case RED -> 7;
            case GREEN -> 8;
        };
    }
}
