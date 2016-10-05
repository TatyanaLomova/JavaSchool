import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Кэширующий прокси должен перехватывать все вызовы методов, помеченных аннотацией @Cache. Если в кэше имеется
 * результат исполнения такого метода, то сразу возвращать его, если нет – вызывать реальный метод, кэшировать
 * результат в своём хранилище и возвращать его.
 *
 * Created by tanya on 05.10.16.
 */
public class MyInvocationHandler implements InvocationHandler {

    // Кэш
    final Map<Sign, Object> cachedResults;
    final MyClass inst;

    public MyInvocationHandler(MyClass obj) {
        cachedResults = new HashMap<Sign, Object>();
        inst = obj;
    }

    // В классе хранятся метод и параметры, с которыми он был вызван
    public final class Sign{

        private Object[] args;
        private Method m;

        public Sign(Object[] arguments, Method m) {
            this.args = arguments;
            this.m = m;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Sign sign = (Sign) o;

            if (args.length != sign.args.length) return false;

            for (int i = 0; i < args.length; i++)
                if (!args[i].equals(sign.args[i])) return false;


            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            // if (!Arrays.equals(args, sign.args)) return false;
            return m != null ? m.equals(sign.m) : sign.m == null;

        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(args);
            result = 31 * result + (m != null ? m.hashCode() : 0);
            return result;
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Вызван метод " + method.getName());

        Object result = method.invoke(inst, args);

        if ( method.isAnnotationPresent(Cache.class)){

            // Формируем ключ хэша - метод и параметры, скоторыми он был вызван
            Sign inputData = new Sign(args, method);

            // Если такой метод с такими параметрами не вызывался - вызываем метод, а результат вместе
            // с ключом помещаем в кэш
            if (!cachedResults.containsKey(inputData)){
                result =  method.invoke(inst, args);
                cachedResults.put(inputData, result);
                System.out.println("Вызванный метод будет помещен в кэш");
            }
            // Если по каким-то причинам в кэше хранится null - возвращаем 0
            else if (cachedResults.get(inputData) == null) {
                System.out.print("Возвращаем значение из кэша: ");
                result = 0;
            }   else{
                System.out.print("Возвращаем значение из кэша: ");
                    // в других случаях возвращаем значение из кэша
                    result =  cachedResults.get(inputData);
            }
        }

        // если метод не содержал аннотацию @Cache, то он просто вызывается и возвращается результат
        // (без занесения в кэш)
        // System.out.print("Результат равен ");
        return result;
    }
}