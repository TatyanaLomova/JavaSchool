import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tanya on 21.09.16.
 */

/**
 * Задание: параметризовать методы, используя правило PECS, и реализовать их. 
 */

public class CollectionUtils {


    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {

        destination.addAll(source);

    }

    // Создает новый List
    public static<T> List newArrayList() {

        List<T> array = new ArrayList<>();

        return array;
    }

    // Находит индекс элемента
    public static<T> int indexOf(List<? extends T> source, T o) {

        int index = source.indexOf(o);
        return index;
    }

    /**
     *     возвращаемый новый List, содержащий первые size элементов из передаваемого List'а
     *
     */
    public static<T> List limit(List<? extends T> source, int size) {

        List<T> limitList = new ArrayList<T>(size);

        for (int i = 0; i<size; i++)
            limitList.add(source.get(i));

        return limitList;
    }

    // Добавляет новый элемент
    public static<T> void add(List<? super T> source, T o) {

        source.add(o);
    }

    //Удаляет все элементы
    public static<T> void removeAll(List<? extends T> removeFrom, List<? super T> c2) {
        c2.removeAll(removeFrom);
    }

    //true если первый лист содержит все элементы второго
    public static<T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {

        if (c1.containsAll(c2)) return true;

        return false;

    }

    //true если первый лист содержит хотя-бы 1 второго
    public static<T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {

        for (T elem : c2)
            if (c1.contains(elem)) return true;

        return false;
    }

    // Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T> List range(List <? extends T> list, T min, T max) {

        List <T> rangeList = newArrayList();

        for (T elem : list){

            if (compare(elem, min) >= 0 &&  compare(elem, max) <= 0)
                rangeList.add(elem);
        }

        return rangeList;

    }

    // Метод для сравнения элементов массива
    private static<T> int compare(T val1, T val2) {
        return ((Comparable<? super T>) val1).compareTo(val2);
    }

    // Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T> List range(List <? extends T> list, T min, T max, Comparator<? super T>  comparator) {

        List <T> rangeList = newArrayList();

        for (T elem : list){

            if (comparator.compare(min, elem) > 0 &&  comparator.compare(max, elem) < 0)
                rangeList.add(elem);
        }

        return rangeList;

    }

    public static void main(String[] args) {

        CollectionUtils cu = new CollectionUtils();

        List <Integer> intArr = newArrayList();
        List <Integer> intArr2 = newArrayList();

        //System.out.print("Массив: ");
        for (int i = 0; i < 10; i++){
            add(intArr2,i);
            add(intArr, i+1);
            //System.out.print(intArr.get(i) + " ");  // 1 2 3 4 5 6 7 8 9 10
        }

        System.out.println();
        System.out.println("Индекс элемента со значением 5 равен " + indexOf(intArr, 5)); // 4

        intArr = limit(intArr, 5);

        System.out.print("Ограниченный 5 элементами массив: ");
        for (Integer elem : intArr ) {
            System.out.print(elem + " ");
        }                                           // 1 2 3 4 5

        System.out.println();
        System.out.println("Массив intArr содержит массив intArr2: " + containsAll(intArr,intArr2));    // false
        System.out.println("Массив intArr содержит чачть массива intArr2: " + containsAny(intArr,intArr2)); //true


        intArr2 = range(intArr2, 0, 4);
        for (Integer elem : intArr2 ) {
            System.out.print(elem + " ");
        }

        // НЕ СМОГЛА НАПИСАТЬ КОМПАРАТОР ДЛЯ ПАРАМЕТРИЗИРОВАННОЙ КОЛЛЕКЦИИ
        // intArr2 = range(intArr2, 0, 4, comparator);



    }

}
