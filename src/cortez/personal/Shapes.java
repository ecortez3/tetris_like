package cortez.personal;

public class Shapes {

    private final static int[][] qShape = new int[][] {
            { 0,1 },
            { 0,1 }
    };

    private final static int[][] zShape = new int[][] {
            { 0,1 },
            { 1,2 }
    };

    private final static int [][] sShape = new int[][] {
            { 1,2 },
            { 0,1 }
    };

    private final static int[][] tShape = new int[][] {
            { 0,1,2 },
            { 1 }
    };

    private final static int[][] iShape = new int[][] {
            { 0 },
            { 0 },
            { 0 }
    };

    private final static int[][] lShape = new int[][] {
            { 0 },
            { 0 },
            { 0,1 }
    };

    private final static int[][] jShape = new int[][] {
            { 1 },
            { 1 },
            { 0,1 }
    };

    public static int[][] getShapeCoordinates(String type) {
        switch (type){
            case "Q":
                return qShape;
            case "Z":
                return zShape;
            case "S":
                return sShape;
            case "T":
                return tShape;
            case "I":
                return iShape;
            case "L":
                return lShape;
            default:
                return jShape;
        }
    }
}
