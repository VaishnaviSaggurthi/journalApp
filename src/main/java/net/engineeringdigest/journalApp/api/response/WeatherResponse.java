package net.engineeringdigest.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// POJO to JSON --> serialization -- used in postman (we have written code in pojo then in postman we sent the request as json)
// JSON to POJO --> de-serialization -- used here (we converted the api response i.e. json to this pojo)
@Getter
@Setter
public class WeatherResponse{
    private Current current;

    @Getter
    @Setter
    public static class Current{

        private int temperature;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

        private int feelslike;
    }
}
