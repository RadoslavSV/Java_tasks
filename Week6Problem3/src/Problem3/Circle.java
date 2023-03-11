package Problem3;

public class Circle extends Point{
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        setRadius(radius);
    }

    public Circle() {
        this(0, 0, 2);
    }

    public Circle(Circle circle) {
        this(circle.getX(), circle.getY(), circle.radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius > 0){
            this.radius = radius;
        }
        else{
            this.radius = 2;
        }
    }

    @Override
    public String toString() {
        return String.format("Circle with center %s and radius %d",
                super.toString(), radius);
    }

    @Override
    public boolean greater(Comparable obj) {
        if(obj instanceof Circle){
            Circle circle2 = (Circle) obj;
            return super.greater(circle2) ||
                    (!super.greater(circle2)
                            && this.radius > circle2.radius);
        }
        return true;
    }

//    public static void main(String[] args) {
//        Circle c1 = new Circle(1, 1, 5);
//        Circle c2 = new Circle(1, 1, 3);
//        Point p1 = new Point(2, 2);
//
//        System.out.println(p1 instanceof Circle);
//        System.out.println(c2 instanceof Point);
//        System.out.println(c2.greater(c1));
//    }
}
