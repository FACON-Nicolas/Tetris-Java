package faconnicolas.project.tetris.controller.gamestate;

import faconnicolas.project.tetris.Tetris;
import faconnicolas.project.tetris.controller.Panel;
import faconnicolas.project.tetris.view.Window;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class RunningGameState extends GameState {

    public RunningGameState(Panel panel) {
        super(panel);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case VK_DOWN -> panel.getTetriminos().down();
            case VK_RIGHT -> panel.getTetriminos().right();
            case VK_LEFT -> panel.getTetriminos().left();
            case VK_SPACE -> panel.getTetriminos().place();
            default -> {
                if (panel.getKeys().contains(keyEvent.getKeyCode())) return;
                switch (keyEvent.getKeyCode()) {
                    case VK_UP -> panel.getTetriminos().rotate();
                    case VK_ESCAPE -> {
                        panel.setGameState(nextState());
                    }
                } panel.getKeys().add(keyEvent.getKeyCode());
            }
        }
    }

    @Override
    public IGameState nextState() {
        return new PausedGameState(panel);
    }

    /**
     * Update method, called at each frame
     */
    @Override
    public void update() {
        panel.getTetriminos().update();
        panel.update();
        panel.getTetriminos().draw(panel.getGraphics());
    }
}
