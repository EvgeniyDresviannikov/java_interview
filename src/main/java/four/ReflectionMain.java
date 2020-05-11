package four;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReflectionMain {
    public static void main(String[] args) throws Exception {
        ReflectionMain reflectionMain = new ReflectionMain();

        //reflectionMain.printAllClassFields(TestReflection.class);

        TestReflection testReflection = new TestReflection();

        reflectionMain.callMethodByName(testReflection, "test");
    }
    <T> void printAllClassFields(Class<T> aClass) {
        Arrays.stream(aClass.getDeclaredFields()).map(x -> x.toString().substring(x.toString().lastIndexOf(".")+1)).sorted().forEach(System.out::println);
    }

    void callMethodByName(Object object, String methodName, Object... params) throws Exception {
        Map<String, Method> methods =
                Arrays.stream(object.getClass().getDeclaredMethods())
                                        .collect(Collectors.toMap(x -> x.toString(), x -> x));
        for(Map.Entry item : methods.entrySet()) {
            String substrKey = item.getKey().toString();
            substrKey = substrKey.substring(0, substrKey.lastIndexOf("("));
            substrKey = substrKey.substring(substrKey.lastIndexOf(".")+1);
            if (substrKey.equals(methodName)) {
                Method method = (Method) item.getValue();
                method.invoke(object, params);
            }
        }
    }

}
