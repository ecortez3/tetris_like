package cortez.personal.shapes;

public class JShape extends Shapes {

    final static int[][] shape = new int[][] {
            { 1 },
            { 1 },
            { 0,1 }
    };

    static int[][] getShape() {
        return shape;
    }
}
