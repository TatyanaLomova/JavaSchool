package Term;

/**
 * Created by tanya on 25.09.16.
 */
public class TerminalServerImpl {

    private static String accountStatus;
    private static int currMoney;

    public static int getAccountStatus() {
        return currMoney;
    }

    public static void getMoney(int money){
        currMoney -= money;
    }

    public static void putMoney(int money){
        currMoney += money;
    }
}
