package hello.refactoring.Chapter10.IntroduceParameterObjectV2;

import java.util.Date;

public class Entry {
    private Date _chargeDate;
    private double _value;


    public Date getChargeDate() {
        return _chargeDate;
    }

    public double getValue() {
        return _value;
    }

    Entry (double value, Date chargeDate){
        _value = value;
        _chargeDate = chargeDate;
    }

}
