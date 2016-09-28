package Term;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by tanya on 25.09.16.
 */
public class Main {

    // Печать меню
    private static void printMenu(){
        System.out.println("\nВыберите необходимое действие: ");
        System.out.println("1. Проверить состояние счета\n"  +"2. Положить деньги на счет\n" +
                "3. Снять деньги со счета\n" + "4. Выход");
    }

    // Вызов методов класса TerminalImpl
    private static void checkMenuChoice() throws TerminalException, InterruptedException, InvalidPinException {



        TerminalImpl terminal = new TerminalImpl();

        Scanner sc = new Scanner(System.in);

        // В случае выбора пунктов, связанных с терминалом (1 - 3):
        //  1) выполняется проверка пароля
        //  2) выполняется выбранное действие
        //  3) в случае исключения предлагается или продолжить текущее действие, или вернуться в меню
        // В остальных случаях выход
        switch (sc.next()) {
            case "1":
                terminalCheckAccountStatus(terminal);
                break;
            case "2":
                terminalPutMoney(terminal, sc);
                break;
            case "3":
                terminalWithdrawMoney(terminal, sc);
                break;
            case "4":
            default:
                break;
        }
    }

    private static void terminalCheckAccountStatus(TerminalImpl terminal){
        do {
            try {
                terminal.checkAccountStatus();
                break;
            } catch (TerminalException msg) {
                System.out.println(msg.getMessage());
            } catch (InvalidPinException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
    private static void terminalPutMoney(TerminalImpl terminal, Scanner sc){
        boolean flag = true;
        do {
            try {
                terminal.putMoney();
                break;
            } catch (TerminalException msg) {
                System.out.println(msg.getMessage());
                if (sc.next().equals("n")) flag = false;
            } catch (InvalidPinException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (flag);
    }
    private static void terminalWithdrawMoney(TerminalImpl terminal, Scanner sc){
        boolean flag = true;
        do {
            try {
                terminal.withdrawMoney();
                break;
            } catch (TerminalException msg) {
                System.out.println(msg.getMessage());
                if (sc.next().equals("n")) flag = false;
            } catch (InvalidPinException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (flag);
    }

    public static void main(String[] args) throws IOException, InvalidPinException, InterruptedException, TerminalException {

        while (true){

            printMenu();
            checkMenuChoice();
        }
    }
}
