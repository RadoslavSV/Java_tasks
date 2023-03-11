package Problem3;

public class Test {
    public static void main(String[] args) {
        Point pt1 = new Point(3, 4);
        Point pt2 = new Point(6, 9);
        System.out.printf("Is point1 greater than point2? %b\n", pt1.greater(pt2));

        Circle crl1 = new Circle(3, 4, 2);
        Circle crl2 = new Circle(1, 1, 4);
        System.out.printf("Is circle1 greater than circle2? %b\n", crl1.greater(crl2));

        Cylinder cyldr1 = new Cylinder(10, 3, 5, 7);
        Cylinder cyldr2 = new Cylinder(10, 3, 5, 3);
        System.out.printf("Is cylinder1 greater than cylinder2? %b\n", cyldr1.greater(cyldr2));
    }
}
