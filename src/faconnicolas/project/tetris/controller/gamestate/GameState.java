package faconnicolas.project.tetris.controller.gamestate;

import faconnicolas.project.tetris.controller.Panel;

public abstract class GameState implements IGameState {

    protected final Panel panel;

    protected GameState(Panel panel) {
        this.panel = panel;
    }
}
