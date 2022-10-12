package hello.Pattern.Ch2.opserver.pratice.opserverobject;


import hello.Pattern.Ch2.opserver.pratice.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {
    private WeatherData weatherData;
    private float temperature;
    private float humidity;

    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("현재 온도 : "+temperature+"F, 습도 : "+humidity+"%");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
