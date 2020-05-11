package four;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        AnnotationTest annotationTest = new AnnotationTest();
        A a = new A();
        annotationTest.callMethodByWeight(a);
    }

    void callMethodByWeight(Object object) throws Exception {
        Arrays.stream(object.getClass().getDeclaredMethods())
                .filter(x -> x.getAnnotation(Weight.class) != null)
                .sorted((x1, x2) -> Integer.compare(x1.getAnnotation(Weight.class).value(), x2.getAnnotation(Weight.class).value()))
                .forEach(x -> {
                    try {
                        x.invoke(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }
}
