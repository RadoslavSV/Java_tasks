package Problem5.package3;
import Problem5.package1.A;
import Problem5.package2.B;

public class C extends B {
    public A convertToA() {
        System.out.println("convertToA() called");
        return getInnerB();
    }

    public static void main(String[] args) {
        C objC = new C();
        A objA = objC.convertToA();
    }
}
