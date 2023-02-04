package faconnicolas.project.tetris.grid;

import faconnicolas.project.tetris.window.Positionable;
import faconnicolas.project.tetris.color.Colorable;


/**
 * ICell Interface, extends Positionable and Colorable interfaces
 */
public interface ICell extends Positionable, Colorable {

    /**
     * get row
     *
     * @return row
     */
    int getRow();

    /**
     * get column
     *
     * @return column
     */
    int getColumn();

}
