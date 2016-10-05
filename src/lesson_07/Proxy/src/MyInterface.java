/**
 * Created by tanya on 05.10.16.
 */
public interface MyInterface {


    int getValue();

    void setValue(int val);

    @Cache
    int sumValues(int ... val2);

    @Cache
    int sum2Values(int val1, int val2);

    void printAnswer();

    @Cache
    int getRasn(int val1, int val2);

}
