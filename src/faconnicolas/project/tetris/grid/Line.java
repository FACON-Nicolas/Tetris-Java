package faconnicolas.project.tetris.grid;

import java.util.ArrayList;

public class Line implements ILine {

    private ArrayList<Cell> line;

    public Line() {
        this.line = new ArrayList<>();
    }

    @Override
    public boolean isFull() {
        return line.stream().noneMatch(c -> c.getValue() != 0);
    }

    public ArrayList<Cell> getLine() {
        return new ArrayList<>(line);
    }

    @Override
    public Cell get(int index) {
        return line.get(index);
    }

    @Override
    public void set(int index, Cell cell) {
        line.set(index, cell);
    }
}
