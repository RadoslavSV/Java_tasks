package geometry;

public class Rectangle extends Point {
    private Point ePoint; //lower right corner

    public Rectangle(int[] coords, Point ePoint) {
        super(coords);
        setePoint(ePoint);
    }

    public Rectangle() {
        this(new int[2], new Point(new int[]{1, 1}));
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.getCoords(), rectangle.getePoint());
    }

    public Point getePoint() {
        return ePoint;
    }

    public void setePoint(Point ePoint) {
        if(ePoint!=null) {
            this.ePoint = new Point(ePoint);
        } else {
            this.ePoint = new Point(new int[]{1, 1});
        }
    }

    public int measure() { //perimeter
        int width = ePoint.getCoords()[0] - this.getCoords()[0];
        int height = ePoint.getCoords()[1] - this.getCoords()[1];
        return 2*(width+height);
    }

    @Override
    public String toString() {
        return String.format("Rectangle with upper left corner %s and lower right corner %s", super.toString(), ePoint.toString());
    }
}
