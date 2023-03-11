package Problem5.package2;
import Problem5.package1.A;

public class B {
    protected static class innerB implements A {
        @Override
        public void methodA() {
            System.out.println("methodA() overridden in class B");
        }
    }
    public innerB getInnerB() {
        System.out.println("getInnerB() called");
        return new innerB();
    }
}
