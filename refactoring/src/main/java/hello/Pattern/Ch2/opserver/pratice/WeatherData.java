package hello.Pattern.Ch2.opserver.pratice;

import hello.Pattern.Ch2.opserver.pratice.opserverobject.Observer;

import java.util.ArrayList;
import java.util.List;

/*
* 신문사를 주제(one), 구독자들을 옵저버(객제들, many)
* 신문사 + 구독자 = 옵저버 패턴
*
* 옵저버 패천 : 한 객체의 상태가 바뀌면
* 그 객체에 의존하는 다른 객체에게 연락이 가고
* 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many)의존성을 정의
*
* 주제는 바뀔 수 있고, 옵저버 객체들은 새로 생기거나 없어질 수 있다.
* 옵저버 패턴 구현은
* 주제 인터페이스와 옵저버 인터페이스가 들어있는 클래스 디자인으로 구현한다.
* */
public class WeatherData implements Subject{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    void setMeasurements(){

    }


    //위의 3개의 get메소드값이 갱신될 때마다 이 메소드가 호줄된다.
    public void mesurementsChanged(){
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observers){
            observer.update(temperature, humidity, pressure);
        }
    }
}
