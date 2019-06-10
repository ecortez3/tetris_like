package cortez.personal.shapes;

public class LShape extends Shapes {

    final static int[][] shape = new int[][] {
            { 0 },
            { 0 },
            { 0,1 }
    };

    static int[][] getShape() {
        return shape;
    }
}
