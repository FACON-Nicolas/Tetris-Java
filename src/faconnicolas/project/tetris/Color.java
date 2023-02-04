package faconnicolas.project.tetris;

public enum Color {

    RED(java.awt.Color.RED),
    CYAN(java.awt.Color.CYAN),
    BLUE(java.awt.Color.BLUE),
    YELLOW(java.awt.Color.YELLOW),
    ORANGE(java.awt.Color.ORANGE),
    PURPLE(new java.awt.Color(102, 0, 153)),
    GREEN(java.awt.Color.GREEN);

    final java.awt.Color color;

    Color(java.awt.Color color) {
        this.color = color;
    }
}
