package hello.Pattern.Ch2.opserver.pratice;

import hello.Pattern.Ch2.opserver.pratice.opserverobject.CurrentConditionsDisplay;
import hello.Pattern.Ch2.opserver.pratice.opserverobject.ForecastDisplay;
import hello.Pattern.Ch2.opserver.pratice.opserverobject.StatisticsDisplay;

public class WeatherSimulation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

    }
}
