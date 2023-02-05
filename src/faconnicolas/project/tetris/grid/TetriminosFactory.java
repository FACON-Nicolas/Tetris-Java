package faconnicolas.project.tetris.grid;

public class TetriminosFactory {

    /**
     * private Constructor, not used
     */
    private TetriminosFactory() {

    }

    /**
     * get I detriminos.
     *
     * @return
     */
    public static int[][] getI() {
        return new int[][]{
                {0, 2, 0},
                {0, 2, 0},
                {0, 2, 0}
        };
    }

    public static int[][] getT() {
        return new int[][]{
                {0, 0, 0},
                {4, 4, 4},
                {0, 4, 0}
        };
    }

    public static int[][] getJ() {
        return new int[][]{
                {0, 0, 0},
                {5, 5, 5},
                {0, 0, 5}
        };
    }

    public static int[][] getL() {
        return new int[][] {
                {0, 0, 0},
                {6, 6, 6},
                {6, 0, 0}
        };
    }

    public static int[][] getZ() {
        return new int[][] {
                {0, 0, 0},
                {8, 8, 0},
                {0, 8, 8}
        };
    }

    public static int[][] getS() {
        return new int[][] {
                {0, 0, 0},
                {0, 7, 7},
                {7, 7, 0}
        };
    }

    public static int[][] getO() {
        return new int[][] {
                {3, 3, 0},
                {3, 3, 0},
                {0, 0, 0}
        };
    }
}
