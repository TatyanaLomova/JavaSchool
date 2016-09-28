package Term;

/**
 * Created by tanya on 28.09.16.
 */
/**
 * Исключение выбрасывается в случае, если:
 * 1. Пароль не введен (т.е. pin == null)
 * 2. Пароль был введен неверно 3 раза
 */
public class  InvalidPinException extends Exception{

    public  InvalidPinException(String message) {
        super(message);
    }
}