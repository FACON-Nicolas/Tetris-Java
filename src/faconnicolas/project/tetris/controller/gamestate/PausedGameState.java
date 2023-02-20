package faconnicolas.project.tetris.controller.gamestate;

import faconnicolas.project.tetris.Tetris;
import faconnicolas.project.tetris.controller.Panel;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ESCAPE;

public class PausedGameState extends GameState {


    protected PausedGameState(Panel panel) {
        super(panel);
        Graphics g = panel.getGraphics();
        // rgba -> 0, 0, 0, 0.3
        g.setColor(new Color(0xAA000000, true));
        g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case VK_ENTER -> System.exit(0);
            case VK_ESCAPE -> {
                panel.setGameState(nextState());
                panel.getGraphics().clearRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
                Graphics g = panel.getGraphics();
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 1600, 900);
            }
        }
    }

    @Override
    public IGameState nextState() {
        return new RunningGameState(panel);
    }

    /**
     * Update method, called at each frame
     */
    @Override
    public void update() {
        Graphics g = panel.getGraphics();
        g.setColor(Color.RED);
        g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 5F));
        g.drawString("GAME PAUSED", 600, 300);
        g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 0.6f));
        g.drawString("Escape - Resume", 650, 350);
        g.drawString("Enter - Quit", 650, 400);

    }
}
