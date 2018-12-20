package sample.functional;

public class TableValues {
    private Double X, Y;

    public TableValues(Double x, Double y) {this.X = x; this.Y = y;}

    public Double getX() { return X; }

    public Double getY() { return Y; }

    public void setX(Double a) { this.X = a; }

    public void setY(Double b) { this.Y = b; }

    public String toString() {
        return "["+X+"; "+Y+"]";
    }
}
