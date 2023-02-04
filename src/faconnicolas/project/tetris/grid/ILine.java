package faconnicolas.project.tetris.grid;

public interface ILine {

    boolean isFull();

    Cell get(int index);

    void set(int index, Cell cell);
}
