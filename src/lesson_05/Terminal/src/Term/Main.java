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
    private static void checkMenuChoice() throws TerminalException, InterruptedException, PinException {

        boolean flag = true;

        TerminalImpl terminal = new TerminalImpl();

        Scanner sc = new Scanner(System.in);

        // В случае выбора пунктов, связанных с терминалом (1 - 3):
        //  1) выполняется проверка пароля
        //  2) выполняется выбранное действие
        //  3) в случае исключения предлагается или продолжить текущее действие, или вернуться в меню
        // В остальных случаях выход
        switch (sc.next()) {
            case "1":
                do {
                    try {
                        terminal.checkAccountStatus();
                        break;
                    } catch (TerminalException msg) {
                        System.out.println(msg.getMessage());
                    }
                } while (true);
                break;
            case "2":
                do {
                    try {
                        terminal.putMoney();
                        break;
                    } catch (TerminalException msg) {
                        System.out.println(msg.getMessage());
                        if (sc.next().equals("n")) flag = false;
                    }
                } while (flag);
                break;
            case "3":
                do {
                    try {
                        terminal.withdrawMoney();
                        break;
                    } catch (TerminalException msg) {
                        System.out.println(msg.getMessage());
                        if (sc.next().equals("n")) flag = false;
                    }
                } while (flag);
                break;
            case "4":
            default:
                System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException, PinException, InterruptedException, TerminalException {

        while (true){

            printMenu();
            checkMenuChoice();
        }
    }
}
