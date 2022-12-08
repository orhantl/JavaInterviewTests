public class Point {

    final double x;
    final double y;
    final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double distance(Point p2) {
        double dx = this.x - p2.x;
        double dy = this.y - p2.y;
        double dz = this.z - p2.z;
        double sqrt = Math.sqrt((dx * dx) + (dy * dy) + (dz * dz));
        return sqrt;
    }
}
