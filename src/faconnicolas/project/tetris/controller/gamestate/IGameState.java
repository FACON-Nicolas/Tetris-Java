package faconnicolas.project.tetris.controller.gamestate;

import faconnicolas.project.tetris.model.window.Updatable;

import java.awt.event.KeyEvent;

public interface IGameState extends Updatable {

    void keyPressed(KeyEvent keyEvent);

    IGameState nextState();
}
