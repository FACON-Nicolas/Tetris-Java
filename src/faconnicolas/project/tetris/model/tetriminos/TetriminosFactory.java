package faconnicolas.project.tetris.model.tetriminos;

import faconnicolas.project.tetris.model.player.Player;

import java.util.*;

public class TetriminosFactory {

    /**
     * random object for nextInt
     */
    private static final Random R = new Random();

    /**
     * private Constructor, not used
     */
    private TetriminosFactory() {

    }

    /**
     * get I tetriminos.
     *
     * @return I tetriminos.
     */
    public static int[][] getI() {
        return new int[][]{
                {0, 2, 0},
                {0, 2, 0},
                {0, 2, 0},
                {0, 2, 0}
        };
    }

    /**
     * get T tetriminos.
     *
     * @return T tetriminos.
     */
    public static int[][] getT() {
        return new int[][]{
                {0, 0, 0},
                {4, 4, 4},
                {0, 4, 0}
        };
    }

    /**
     * get J tetriminos.
     *
     * @return J tetriminos.
     */
    public static int[][] getJ() {
        return new int[][]{
                {0, 0, 0},
                {5, 5, 5},
                {0, 0, 5}
        };
    }

    /**
     * get L tetriminos.
     *
     * @return L tetriminos.
     */
    public static int[][] getL() {
        return new int[][] {
                {0, 0, 0},
                {6, 6, 6},
                {6, 0, 0}
        };
    }

    /**
     * get Z tetriminos.
     *
     * @return Z tetriminos.
     */
    public static int[][] getZ() {
        return new int[][] {
                {0, 0, 0},
                {8, 8, 0},
                {0, 8, 8}
        };
    }

    /**
     * get S tetriminos.
     *
     * @return S tetriminos.
     */
    public static int[][] getS() {
        return new int[][] {
                {0, 0, 0},
                {0, 7, 7},
                {7, 7, 0}
        };
    }

    /**
     * get O tetriminos.
     *
     * @return O tetriminos.
     */
    public static int[][] getO() {
        return new int[][] {
                {3, 3, 0},
                {3, 3, 0},
                {0, 0, 0}
        };
    }

    /**
     * Get random tetriminos
     *
     * @return new tetriminos character
     */
    public static String randomTetriminos() {
        Map<String, Integer> map = Player.getInstance().getProbaTetriminos();
        int sum = map.values().stream().mapToInt(Integer::intValue).sum();
        double r = R.nextDouble(1);
        final double[] proba = {0.0};
        StringBuilder key = new StringBuilder();
        map.forEach((k, v) -> {
            if (key.toString().length() > 0) return;
            proba[0] += ((double) v / (double) sum);
            if (r < proba[0])
                key.append(k);
        }); return key.toString();
    }
}
