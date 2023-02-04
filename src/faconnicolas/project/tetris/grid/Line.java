package faconnicolas.project.tetris.grid;

import java.util.ArrayList;

/**
 * Line is here to have lines in my Tetris' grid.
 */
public class Line implements ILine {

    /**
     * line's container
     */
    private ArrayList<Cell> line;

    /**
     * constructor, init line's container.
     */
    public Line() {
        this.line = new ArrayList<>();
    }

    /**
     * check if the line is full thanks to a lambda expression.
     *
     * @return <code>true</code> if full else <code>false</code>
     */
    @Override
    public boolean isFull() {
        return line.stream().noneMatch(cell -> cell.getValue() != 0);
    }

    /**
     * create a line's container copy and returns it.
     *
     * @return a copy fo the line's container.
     */
    public ArrayList<Cell> getLine() {
        return new ArrayList<>(line);
    }

    /**
     * get a specific cell positioned at a specific index.
     *
     * @param index the index to check
     *
     * @return the cell
     */
    @Override
    public Cell get(int index) {
        return line.get(index);
    }

    /**
     * set a specific cell in index
     *
     * @param index cell's index
     *
     * @param cell new cell
     */
    @Override
    public void set(int index, Cell cell) {
        line.set(index, cell);
    }
}
