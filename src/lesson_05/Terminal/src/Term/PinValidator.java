package Term;

import java.util.Scanner;

/**
 * Created by tanya on 25.09.16.
 */

public class PinValidator {

    private static final String pin = "1234";
    private static int cnt = 3;

    public void pinCheck() throws PinException {

        String currPin;

        Scanner sc = new Scanner(System.in);

        validationLoop:
        while (true) {

            if (cnt != 0) {

                System.out.println(" Введите пароль ");
                currPin = sc.next();

                if (currPin == null ) {
                    throw new PinException("Пароль не введен!");
                } else if (!currPin.equals(pin)){
                    cnt--;
                    System.out.println("Пароль введен неверно! У Вас осталось " + cnt + " попытки");
                }
                else break validationLoop;
            }
            else{
                cnt = 3;
                throw new PinException("Пароль введен неверно 3 раза!" + "Терминал будет заблокирован на 5 сек ");
            }
        }
    }

}

/**
 * Исключение выбрасывается в случае, если:
 * 1. Пароль не введен (т.е. pin == null)
 * 2. Пароль был введен неверно 3 раза
 */
class PinException extends Exception{

    public PinException(String message) {
            super(message);
    }
}
