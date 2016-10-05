import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * Created by tanya on 05.10.16.
 */
public class Main {


    public static void main(String[] args) {

        MyClass inst = new MyClass(10);

        InvocationHandler handler = new MyInvocationHandler(inst);
        MyInterface proxy = (MyInterface)
                Proxy.newProxyInstance(
                    MyInterface.class.getClassLoader(),
                    new Class[] { MyInterface.class },
                    handler);

        System.out.println(proxy.getRasn(100, 50)+"\n");
        System.out.println(proxy.getRasn(100, 50)+"\n");
        System.out.println(proxy.getRasn(90, 40)+"\n");
        System.out.println(proxy.getRasn(100, 50)+"\n");

        System.out.println(proxy.getValue()+"\n");
        proxy.setValue(20);
        System.out.println(proxy.getValue()+"\n");

        System.out.println(proxy.sum2Values(10, 10)+"\n");
        System.out.println(proxy.sum2Values(10,210)+"\n");
        System.out.println(proxy.sum2Values(10, 10)+"\n");


        /**
         *
         * C varargs не работает! Не заходит в метод equals(). ПОЧЕМУ
         *
         */
//        System.out.println(proxy.sumValues(10, 10, 20)+"\n");
//        System.out.println(proxy.sumValues(10, 10, 20)+"\n");
//        System.out.println(proxy.sumValues(10, 5, 1)+"\n");
//        System.out.println(proxy.sumValues(10, 10, 20)+"\n");
//        System.out.println(proxy.sumValues(1, 10, 20)+"\n");
//        System.out.println(proxy.sumValues(10, 5, 20)+"\n");

    }
}
