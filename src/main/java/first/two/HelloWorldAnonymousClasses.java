package first.two;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldAnonymousClasses {
    public static void main(String[] args) {
        HelloWorldAnonymousClasses helloWorldAnonymousClasses = new HelloWorldAnonymousClasses();
        System.out.println(helloWorldAnonymousClasses.reverse(12345));
    }

    int reverse(int n) {
        StringBuilder stringBuilder = new StringBuilder(n+"");

        return Integer.valueOf(stringBuilder.reverse().toString());
    }


}