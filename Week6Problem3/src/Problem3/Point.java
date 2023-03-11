package Problem3;

public class Point implements Comparable{
    private int x;
    private int y;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }
    public Point() {
        this(0, 0);
    }
    public Point(Point point) {
        this(point.x, point.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)", x, y);
    }

    @Override
    public boolean greater(Comparable obj) {
        if(obj instanceof Point){
            Point pnt2 = (Point) obj;
            return this.x > pnt2.x || (this.x == pnt2.x && this.y > pnt2.y);
        }
        return true;
    }
}
