package ru.sberbank.javaschool.simplespring;

import ru.sberbank.javaschool.simplespring.x.CImpl;


/**
 * Created by svetlana on 25.09.16.
 */
@Component
public class BImpl implements B{

    //@Autowired
    //private CImpl c;

    private String flag = "We were not in PostConstruct method in BImpl";

    @PostConstruct
    public void init() {

        flag = "We were in PostConstruct method in BImpl";

        //TODO: some logic
    }

    @Override
    public String getSomeData() {
        return flag;
    }
}