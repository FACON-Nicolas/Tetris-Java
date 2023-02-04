package faconnicolas.project.tetris.grid;

import faconnicolas.project.tetris.window.Positionable;
import faconnicolas.project.tetris.color.Colorable;

public interface ICell extends Positionable, Colorable {

    int getRow();

    int getColumn();

}
