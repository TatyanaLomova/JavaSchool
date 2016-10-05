/**
 * Created by tanya on 05.10.16.
 */
public class MyClass implements  MyInterface {

     private int value;

    public MyClass(int val) {
        this.value = val;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int val) {
        this.value = val;
    }

    @Override
    public int sumValues(int ...val2) {

        int sum = 0;

        for (int i : val2)
            sum += i;

        return sum;
    }

    @Override
    public int sum2Values(int val1, int val2) {
        return val1 + val2;
    }


    @Override
    public void printAnswer() {

    }

    @Override
    public int getRasn(int val1, int val2) {

        return  val1 - val2;
    }
}
