package hello.refactoring.Chapter10.IntroduceParameterObjectV2;

import java.util.Date;

public class DateRange {

    private final Date _start;
    private final Date _end;

    DateRange (Date start, Date end){
        _start = start;
        _end = end;
    }

    public Date getStart() {
        return _start;
    }

    public Date getEnd() {
        return _end;
    }

    boolean includes(Date arg){
        return (arg.equals(getStart()) ||
                arg.equals(getEnd()) ||
                (arg.after(getStart()) && arg.before(getEnd()))
        );
    }
}
