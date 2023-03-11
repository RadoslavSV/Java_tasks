package geometry;

public class Line extends Point{ //sPoint
    private Point ePoint;

    public Line(int[] coords, Point ePoint) {
        super(coords);
        this.ePoint = ePoint;
    }

    public Line() {
        this(new int[2], new Point(new int[]{1, 1}));
    }

    public Line(Line line) {
        this(line.getCoords(), line.getePoint());
    }

    public Point getePoint() {
        return ePoint;
    }

    public void setePoint(Point ePoint) {
        if(ePoint!=null) {
            this.ePoint = new Point(ePoint);
        } else {
            this.ePoint = new Point(new int[]{1, 1});;
        }
    }

    public double measure() {
        int x1 = this.getCoords()[0];
        int y1 = this.getCoords()[1];
        int x2 = ePoint.getCoords()[0];
        int y2 = ePoint.getCoords()[1];
        return Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    }

    @Override
    public String toString() {
        return String.format("Line with starting point %s and ending point %s", super.toString(), ePoint.toString());
    }
}
