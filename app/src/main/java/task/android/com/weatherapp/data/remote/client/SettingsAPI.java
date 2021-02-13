package task.android.com.weatherapp.data.remote.client;

import task.android.com.weatherapp.BuildConfig;

public class SettingsAPI {

    public String getApiKey() {
        return BuildConfig.ApiKey;
    }

    public String getWeatherURL(String city) {
        return getBaseURL() + "weather?q=" + city + "&appid=" + getApiKey() + "&units=metric";
    }

    public String getWeatherForecastURL(String lat,String lng) {
        return getBaseURL() + "forecast?lat=" + lat + "&lon="+lng+"&appid=" + getApiKey() + "&units=metric";
    }

    public String getBaseURL() {
        return "https://api.openweathermap.org/data/2.5/";
    }

    public Long getTimeout() {
        return 10000L;
    }

}
