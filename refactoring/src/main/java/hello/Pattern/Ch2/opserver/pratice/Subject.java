package hello.Pattern.Ch2.opserver.pratice;

import hello.Pattern.Ch2.opserver.pratice.opserverobject.Observer;

public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();

}
