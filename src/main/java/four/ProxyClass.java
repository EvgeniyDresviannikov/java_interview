package four;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyClass {
    public static void main(String[] args) throws Exception {
        ProxyClass proxyClass = new ProxyClass();
        BaseImpl base = new BaseImpl();
        base.method1();
        base.method2();
        System.out.println("------------");
        Base baseNew = proxyClass.createProxy(base);
        baseNew.method1();
        baseNew.method2();
    }

    Base createProxy(Base object) throws Exception {

        class Handler implements InvocationHandler{
            private final Base original;

            public Handler(Base original) {
                this.original = original;
            }

            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (original.getClass().getMethod(method.getName()).getAnnotation(Logging.class) != null) {
                    System.out.println("Before call " + method.getName());
                    method.invoke(original);
                    System.out.println("After call " + method.getName());
                } else {
                    method.invoke(original);
                }
                return null;
            }
        }

        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        Handler handler = new Handler(object);
        Base proxy = (Base) Proxy.newProxyInstance(classLoader,
                interfaces,
                handler);
        return proxy;
    }

}
