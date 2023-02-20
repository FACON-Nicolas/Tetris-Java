package faconnicolas.project.tetris.controller.gamestate;

import faconnicolas.project.tetris.Tetris;
import faconnicolas.project.tetris.controller.Panel;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class GameOverGameState extends GameState {

    public GameOverGameState(Panel panel) {
        super(panel);
        Graphics g = panel.getGraphics();
        g.setColor(new Color(0xAA000000, true));
        g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case VK_ESCAPE -> System.exit(0);
            case VK_SPACE -> panel.reset();
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
        g.drawString("GAME OVER", 600, 300);
        g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 0.6f));
        g.drawString("Space - Retry", 650, 350);
        g.drawString("Escape - Quit", 650, 400);
    }
}
