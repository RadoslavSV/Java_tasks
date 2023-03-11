package geometry;

public class Point {
    private int[] coords; //[x;y]

    public Point() {
        this(new int[2]); //[0;0]
    }

    public Point(int[] coords) {
        setCoords(coords);
    }

    public int[] getCoords() {
        int[] copy = new int[coords.length];
        for(int i=0; i<coords.length; i++) {
            copy[i] = coords[i];
        }
        return copy;
    }

    public Point(Point point) {
        this(point.getCoords());
    }

    public void setCoords(int[] coords) {
        if(coords!=null && coords.length==2) {
            this.coords = new int[coords.length];
            for(int i=0; i<coords.length; i++) {
                this.coords[i] = coords[i];
            }
        } else {
            this.coords = new int[]{0, 0};
        }
        this.coords = coords;
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)", coords[0], coords[1]); //(x; y)
    }
}

