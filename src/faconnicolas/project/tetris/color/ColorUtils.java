package faconnicolas.project.tetris.color;

public class ColorUtils {

    public static Color getBlue() {
        return Color.BLUE;
    }

    public static Color getRed() {
        return Color.RED;
    }

    public static Color getYellow() {
        return Color.YELLOW;
    }

    public static Color getCyan() {
        return Color.CYAN;
    }

    public static Color getPurple() {
        return Color.PURPLE;
    }

    public static Color getOrange() {
        return Color.ORANGE;
    }

    public static Color getGreen() {
        return Color.GREEN;
    }

    public static Color getGrey() {
        return Color.GREY;
    }

    public static Color getColor(int value) {
        return switch(value) {
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

}
