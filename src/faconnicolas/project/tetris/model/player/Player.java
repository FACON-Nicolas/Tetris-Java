package faconnicolas.project.tetris.model.player;

import faconnicolas.project.tetris.model.grid.IGrid;
import faconnicolas.project.tetris.model.window.Updatable;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements Updatable {

    /**
     * player unique instance
     */
    private static final Player PLAYER = new Player();

    private Map<String, Integer> probaTetriminos = new HashMap<>();

    /**
     * playyer name
     */
    private final String NAME;

    /**
     * player score
     */
    private int score = 0;

    /**
     * player grid
     */
    private IGrid grid;

    /**
     * get unique instance of player.
     *
     * @return instance
     */
    public static Player getInstance() {
        return PLAYER;
    }

    /**
     * Player constructor, called one time.
     */
    private Player() {
        try {
            NAME = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        for (String t : List.of("I", "O", "L", "J", "Z", "S", "T"))
            probaTetriminos.put(t, 20);
    }

    /**
     * getter for name
     *
     * @return name
     */
    public String getName() {
        return NAME;
    }

    /**
     * setter for score
     *
     * @param score score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * getter for score
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Update method, called at each frame
     */
    @Override
    public void update() {
        if (grid.tetris()) score += 800;
    }

    /**
     * setter for grid
     *
     * @param grid new grid
     */
    public void setGrid(IGrid grid) {
        this.grid = grid;
    }

    /**
     * to string method
     *
     * @return player's name
     */
    @Override
    public String toString() {
        return "Name: " + NAME;
    }

    /**
     * get proba tetriminos map.
     *
     * @return proba tetriminos map
     */
    public Map<String, Integer> getProbaTetriminos() {
        return probaTetriminos;
    }

    /**
     * increment the value for the tetriminos given in parameter
     *
     * @param value tetriminos value
     */
    public void increment(String value) {
        probaTetriminos.computeIfPresent(value, (k, v) -> v + 1);
    }

    /**
     * decrement the value for the tetriminos given in parameter
     *
     * @param value tetriminos value
     */
    public void decrement(String value) {
        probaTetriminos.computeIfPresent(value, (k, v) -> v - 1);
    }
}
