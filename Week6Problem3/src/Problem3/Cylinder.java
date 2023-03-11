package Problem3;

public class Cylinder extends Circle{
    private int height;

    public Cylinder(int x, int y, int radius, int height) {
        super(x, y, radius);
        setHeight(height);
    }

    public Cylinder() {
        this(0, 0, 2, 5);
    }

    public Cylinder(Cylinder cylinder) {
        this(cylinder.getX(), cylinder.getY(), cylinder.getRadius(),
                cylinder.height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0){
            this.height = height;
        }
        else{
            this.height = 5;
        }
    }

    @Override
    public String toString() {
        return String.format("Cylinder with base %s and height: %d",
                super.toString(), height);
    }

    @Override
    public boolean greater(Comparable obj) {
        if(obj instanceof Cylinder) {
            Cylinder cyldr2 = (Cylinder) obj;
            return super.greater(cyldr2) || (!super.greater(cyldr2) && this.height>cyldr2.height);
        }
        return true;
    }
}
