package faconnicolas.project.tetris.model.player;

import faconnicolas.project.tetris.model.grid.IGrid;
import faconnicolas.project.tetris.model.window.Updatable;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Player implements Updatable {

    /**
     * player unique instance
     */
    private static final Player PLAYER = new Player();

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

    @Override
    public String toString() {
        return "Name: " + NAME;
    }
}
