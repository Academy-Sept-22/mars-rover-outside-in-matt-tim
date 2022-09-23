public class RoverLocation {
    private final int x;
    private final int y;
    private final String orientation;

    public RoverLocation(int X, int Y, String Orientation) {
        x = X;
        y = Y;
        orientation = Orientation;
    }

    @Override
    public String toString() {
        return "RoverLocation{" +
                "x=" + x +
                ", y=" + y +
                ", orientation='" + orientation + '\'' +
                '}';
    }
}
