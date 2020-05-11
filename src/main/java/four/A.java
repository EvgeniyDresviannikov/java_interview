package four;

class A {
    @Weight(10)
    void method1() {
        System.out.println("method1 called");
    }

    @Weight(3)
    void method2() {
        System.out.println("method2 called");
    }

    @Weight(21)
    void method3() {
        System.out.println("method3 called");
    }
}
