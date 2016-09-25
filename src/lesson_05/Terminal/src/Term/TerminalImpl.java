package Term;

import java.util.Scanner;

/**
 * Created by tanya on 25.09.16.
 */

interface  Terminal{

    /**
     *  Метод проверяет состояние счета
     */
    void checkAccountStatus() throws PinException, TerminalException, InterruptedException;

    /**
     *  Метод для снятия наличных со счета. Корректными считаются суммы, кратные 100
     */
    void withdrawMoney() throws PinException, TerminalException, InterruptedException;

    /**
     *  Метод для внесения наличных на счет. Корректными считаются суммы, кратные 100
     */
    void putMoney() throws PinException, TerminalException, InterruptedException;

}


public class TerminalImpl implements Terminal {

    private final TerminalServerImpl server = new TerminalServerImpl();
    private final PinValidator pinValidator = new PinValidator();

    // Переменная-флаг, регламентные работы
    private static int flag = 1;


    @Override
    public void checkAccountStatus() throws PinException, TerminalException, InterruptedException {

        if (flag++ % 4 == 0)
            throw new TerminalException("Ведутся регламентные работы");

        // Проверка пароля
        pinCheck();

        System.out.println("На вашем счете осталось " + Integer.toString(server.getAccountStatus())
                + " денег");
    }

    @Override
    public void withdrawMoney() throws PinException, TerminalException, InterruptedException {

        if (flag++ % 5 == 0)
            throw new TerminalException("Ведутся регламентные работы");

        // Проверка пароля
        pinCheck();

        System.out.println("Введите сумму, которую желаете снять");

        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();

        if ( (money % 100) != 0) throw new TerminalException("Необходимо ввести сумму, кратную 100. Продолжить? y/n");
        else if ((server.getAccountStatus() - money) < 0) throw new TerminalException("Недостаточно средств на счете" +
        " Продолжить? y/n");
             else server.getMoney(money);
    }

    @Override
    public void putMoney() throws PinException, TerminalException, InterruptedException {

        if (flag++ % 3 == 0)
            throw new TerminalException("Ведутся регламентные работы");

        // Проверка пароля
        pinCheck();

        System.out.println("Введите сумму, которую желаете внести");

        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();

        if ( (money % 100) != 0) throw new TerminalException("Необходимо ввести сумму, сумму кратную 100."+
                " Продолжить? y/n");
        else server.putMoney(money);

    }

    // Метод с вызовом проверки пароля
    private void pinCheck() throws InterruptedException {

        do {
            try {
                pinValidator.pinCheck();
                break;
            } catch (PinException msg) {
                System.out.println(msg.getMessage());
                // Блокировка консоли на 5 сек
                Thread.sleep(5000);
            }
        } while (true);
    }

}


/**
 * Исключение выбрасывается, если:
 * 1. Ведутся регламентные работы
 * 2. Недостаточно денег на счете
 * 3. Введена невераня сумма (должна быть кратна 100)
 */
class TerminalException extends Exception {

    public TerminalException(String message) {
        super(message);
    }
}
