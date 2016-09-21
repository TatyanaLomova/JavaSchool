import java.util.*;

/**
 * Created by tanya on 21.09.16.
 */
interface CountMap<T> {

    // добавляет элемент в этот контейнер. 
    void add(T o);

    //Возвращает количество добавлений данного элемента
    int getCount(T o);

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    int remove(T o);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значения
    void addAll(CountMap<T> source);

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<? super T, Integer>  destination);
}



public class CountMapIml<T> implements CountMap<T>{

    private List< Pair <T> > array;

    private class Pair<T> {

        public T key;
        private int value;

        public Pair(T k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    public CountMapIml() {
        array = new ArrayList<>();
    }

    @Override
    public void add(T o) {

        for (Pair node : array)
            if (node.key.equals(o)){
                node.value++;
                return;
            }

        array.add(new Pair<T>(o,1));
    }

    @Override
    public int getCount(T o) {

        for (Pair node : array)
            if (node.key.equals(o)){
               return node.value;
            }

        return 0;
    }

    @Override
    public int remove(T o) {

        for (Pair node : array)
            if (node.key.equals(o))
                if (node.value != 1)
                    return node.value--;
                else
                    array.remove(node);
        return 1;
    }

    @Override
    public int size() {

       return array.size();
    }


    @Override
    public void addAll(CountMap<T> source) {

        for (Pair node: array)
            source.add((T)node.key);

        //НЕ СМОГЛА РЕАЛИЗОВАТЬ МЕТОД

    }

    @Override
    public Map toMap() {

        Map<? super T,Integer> map = new HashMap<T, Integer>();

        for (Pair node: array)
            map.put((T)node.key, node.value);

        return map;
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {

        for (Pair node: array)
            destination.put((T)node.key, node.value);

    }

    public static void main(String[] args) {

        CountMap<Integer> map = new CountMapIml<>();

        Map<Integer, Integer> newMap;

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(7);
        map.add(10);

        System.out.println(map.size());         // 4
        System.out.println(map.remove(10));     // 3
        System.out.println(map.getCount(10));   // 2

        System.out.println(map.toMap());    // {5=2, 6=1, 7=1, 10=2}

    }
}