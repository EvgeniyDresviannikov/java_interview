package four;

public class BaseImpl implements Base {

    @Override
    @Logging
    public void method1() {
        System.out.println("method 1 called");
    }

    @Override
    public void method2() {
        System.out.println("method 2 called");
    }
}
