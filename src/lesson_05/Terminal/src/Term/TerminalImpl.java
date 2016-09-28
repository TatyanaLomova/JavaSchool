package Term;

import java.util.Scanner;

/**
 * Created by tanya on 25.09.16.
 */

interface  Terminal{

    /**
     *  Метод проверяет состояние счета
     */
    void checkAccountStatus() throws InvalidPinException, TerminalException, InterruptedException;

    /**
     *  Метод для снятия наличных со счета. Корректными считаются суммы, кратные 100
     */
    void withdrawMoney() throws InvalidPinException, TerminalException, InterruptedException;

    /**
     *  Метод для внесения наличных на счет. Корректными считаются суммы, кратные 100
     */
    void putMoney() throws InvalidPinException, TerminalException, InterruptedException;

}


public class TerminalImpl implements Terminal {

    private final TerminalServerImpl server = new TerminalServerImpl();
    private final PinValidator pinValidator = new PinValidator();

    // Переменная-флаг, регламентные работы
    private static int flag = 1;

    // Переменная-счетчик количества неверных пинов
    private static int cnt = 3;

    @Override
    public void checkAccountStatus() throws InvalidPinException, TerminalException, InterruptedException {

        if (flag++ % 4 == 0)
            throw new TerminalException("Ведутся регламентные работы. Попробовать снова? y/n");

        // Проверка пароля
        pinCheck();

        System.out.println("На вашем счете осталось " + Integer.toString(server.getAccountStatus())
                + " денег");
    }

    @Override
    public void withdrawMoney() throws InvalidPinException, TerminalException, InterruptedException {

        if (flag++ % 5 == 0)
            throw new TerminalException("Ведутся регламентные работы. Попробовать снова? y/n");

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
    public void putMoney() throws InvalidPinException, TerminalException, InterruptedException {

        if (flag++ % 3 == 0)
            throw new TerminalException("Ведутся регламентные работы. Продолжить? y/n");

        // Проверка пароля
        pinCheck();

        System.out.println("Введите сумму, которую желаете внести");

        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();

        if ( (money % 100) != 0) throw new TerminalException("Необходимо ввести сумму, кратную 100."+
                " Продолжить? y/n");
        else server.putMoney(money);

    }

    // Метод с вызовом проверки пароля
    private void pinCheck() throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        String currPin;

        do {
            try {
                System.out.println(" Введите пароль ");
                currPin = sc.next();
                if (currPin == null){
                    throw new TerminalException("Пароль не введен!");
                }
                pinValidator.validate(currPin);
                break;
            } catch (InvalidPinException | TerminalException msg) {
                handlingInvalidPinException(msg);
            }
        } while (true);
    }

    private void handlingInvalidPinException(Exception msg) throws InterruptedException {
        System.out.print(msg.getMessage());
        cnt--;
        // Блокировка консоли на 5 сек
        if (cnt == 0) {
            System.out.println("\nПароль введен неверно 3 раза!" + "Терминал будет заблокирован на 5 сек ");
            Thread.sleep(5000);
            cnt = 3;
        }
        else System.out.println(" У Вас осталось " + cnt + " попытки");
    }

}
