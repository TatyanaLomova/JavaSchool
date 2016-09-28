package Term;

import java.util.Scanner;

/**
 * Created by tanya on 25.09.16.
 */

public class PinValidator {

    private static final String pin = "1234";

    public void validate(String currPin) throws  InvalidPinException {

        if (!pin.equals(currPin)) throw new InvalidPinException("Пароль введен неверно!");

    }

}



