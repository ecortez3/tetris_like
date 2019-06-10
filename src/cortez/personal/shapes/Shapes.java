package cortez.personal.shapes;

public class Shapes {

    public static int[][] getShapeCoordinates(String type) {
        switch (type){
            case "Q":
                return QShape.getShape();
            case "Z":
                return ZShape.getShape();
            case "S":
                return SShape.getShape();
            case "T":
                return TShape.getShape();
            case "I":
                return IShape.getShape();
            case "L":
                return LShape.getShape();
            default:
                return JShape.getShape();
        }
    }
}
