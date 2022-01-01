import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private final List<List<Element>> matrix = new ArrayList<>();
    private int width, height;

    Matrix(int width, int height) {
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean setPos(Element c) {
        return true;
    }

    public Element getPos(int x, int y) {
        return new Element(0, 0, ' ', " ");
    }

    public List<List<Element>> getMatrix() {
        return matrix;
    }


}