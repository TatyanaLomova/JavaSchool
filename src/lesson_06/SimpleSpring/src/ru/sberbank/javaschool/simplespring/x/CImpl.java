package ru.sberbank.javaschool.simplespring.x;

import ru.sberbank.javaschool.simplespring.Autowired;
import ru.sberbank.javaschool.simplespring.A;
import ru.sberbank.javaschool.simplespring.Component;
import ru.sberbank.javaschool.simplespring.D;

/**
 * Created by svetlana on 26.09.16.
 */
@Component
public class CImpl implements D {

    //@Autowired
    //private A a;

    public String message;

    @Override
    public String getSomeStr() {
        return message;
    }
}