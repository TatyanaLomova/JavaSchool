import java.io.*;
import java.util.*;

/**
 * Created by tanya on 18.09.16.
 */
public class MyClass {

    private String inputFile;

    public MyClass(String inFile) {
        this.inputFile = inFile;
    }

    /**
     * This method adds Strings in collection
     * @param collection
     */
    private void readStrings (Collection collection){

        try(Scanner sc = new Scanner(new File(inputFile))){
            while (sc.hasNext())
                collection.add(sc.next());

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

     /**
     * This method counts the number of different Strings
     */
    public void countStrings() {

        HashSet<String> myHashSet = new HashSet<>();

        readStrings(myHashSet);

        System.out.println("Number of different strings is " + myHashSet.size());
    }


    /**
     * This method sorts different Strings by length and name
     */
    public void sortStrings() {

        TreeSet<String> myTreeSet = new TreeSet<>();

        readStrings(myTreeSet);

        System.out.println("Sorted by lenght and name Strings: " + myTreeSet);
    }

    /**
     * This method counts number of String repeats
     */
    public void numberOfRepeat(){

        Map <String, Integer> myHashMap = new HashMap <> ();

        String line;
        int value;

        System.out.print("String's repeats:");

        try(Scanner sc = new Scanner(new File(inputFile))){
            while (sc.hasNext()) {

                line = sc.next();

                if (!myHashMap.containsKey(line))
                    myHashMap.put(line, 1);
                else {
                    value = myHashMap.get(line);
                    value++;
                    myHashMap.put(line, value);
                }
            }
            System.out.println(myHashMap);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method prints Strings in reverse order
     */
    public void reverseString(){

        // Also ArrayList can be used
        LinkedList <String> myLinkedList = new LinkedList<> ();

        readStrings(myLinkedList);

        System.out.println("Strings in reverse order:");

        while (myLinkedList.size() != 0)
            System.out.println(myLinkedList.pollLast() + " ");
    }

    /**
     * In this method Strings are printed using iterator
     */
    public void descIterator(){

        ArrayList <String> myArrayList = new ArrayList<>();

        readStrings(myArrayList);

        ListIterator<String> iter = myArrayList.listIterator(myArrayList.size());

        System.out.println("Strings in reverse order (use iterator):");

        while (iter.hasPrevious())
            System.out.println(iter.previous());
    }


    /**
     * This method prints String, which number is passed
     * @param i - number of String
     */
    public void getString(int i){

        List<String> myArrayList = new ArrayList<> ();

        readStrings(myArrayList);

        System.out.println("String with number " + i + " is: " + myArrayList.get(i-1));
    }

    public static void main(String[] args) {

        MyClass test = new MyClass("input.txt");
        //test.countStrings();
        //test.getString(7);
        //test.sortStrings();
        //test.numberOfRepeat();
        test.reverseString();
        //test.descIterator();
    }
}


