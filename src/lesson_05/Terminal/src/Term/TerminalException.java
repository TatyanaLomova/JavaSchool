package Term;

/**
 * Created by tanya on 28.09.16.
 */

/**
 * Исключение выбрасывается, если:
 * 1. Ведутся регламентные работы
 * 2. Недостаточно денег на счете
 * 3. Введена невераня сумма (должна быть кратна 100)
 */
public class TerminalException extends Exception {

    public TerminalException(String message) {
        super(message);
    }
}