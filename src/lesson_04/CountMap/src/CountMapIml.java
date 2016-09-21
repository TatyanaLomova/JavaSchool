import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    void toMap(Map destination);
}



public class CountMapIml<T> implements CountMap<T>{


    public CountMapIml() {
        Map
    }

    @Override
    public void add(T o) {


    }

    @Override
    public int getCount(T o) {

      return count;
    }

    @Override
    public int remove(T o) {

        return count;
    }

    @Override
    public int size() {

       return 0;
    }

    @Override
    public void addAll(CountMap<T> source) {

    }

    @Override
    public Map toMap() {
        return null;
    }

    @Override
    public void toMap(Map destination) {

    }

    public static void main(String[] args) {

        CountMap<Integer> map = new CountMapIml<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        // int count = map.getCout(5); // 2
        // int count = map.getCout(6); // 1
        // int count = map.getCout(10); // 3*/
    }
}