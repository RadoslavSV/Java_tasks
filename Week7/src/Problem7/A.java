package Problem7;

public class A {
    private int value;

    private int doubleValue(int v) {
        System.out.println("doubleValue() method called for value " + value);
        return 2*v;
    }

    public A(int value) {
        this.value = value;
    }

    public class innerA {
        public void modifyValue() {
            System.out.println("Modifying value with doubleValue() method through inner class");
            value = doubleValue(value);
        }
    }

    public void accessInnerA() {
        innerA iA = new innerA();
        iA.modifyValue();
        System.out.printf("Value after modification is %d\n", value);
    }

    public static void main(String[] args) {
        A obj = new A(-43);
        obj.accessInnerA();
    }
}
