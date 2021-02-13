package task.android.com.weatherapp.data.repository;

import android.util.Log;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Single;
import task.android.com.weatherapp.data.remote.client.APIClient;
import task.android.com.weatherapp.data.remote.client.GsonRequest;
import task.android.com.weatherapp.data.remote.client.SettingsAPI;
import task.android.com.weatherapp.data.remote.model.CityForecast;
import task.android.com.weatherapp.data.remote.model.CityWeather;

public class WeatherRepository {
    private static final String TAG = WeatherRepository.class.getSimpleName();
    APIClient remote;
    SettingsAPI settingsAPI;

    @Inject
    public WeatherRepository(APIClient remote, SettingsAPI settingsAPI) {
        this.remote = remote;
        this.settingsAPI = settingsAPI;
    }

    public Single<CityWeather> getCityWeather(String cityName) {
        return Single.create(emitter -> remote.getRequestQueue().add(new GsonRequest<CityWeather>(settingsAPI.getWeatherURL(cityName), CityWeather.class, new HashMap<>(), response -> {
            if (response != null) {
                emitter.onSuccess(response);
            } else {
                emitter.onError(new Throwable("Error reaching server"));
            }
        }, error -> {
            emitter.onError(error);
        })));
    }

    public Single<CityForecast> getCityWeatherForecast(String lat, String lng) {
        return Single.create(emitter -> remote.getRequestQueue().add(new GsonRequest<CityForecast>(settingsAPI.getWeatherForecastURL(lat, lng), CityForecast.class, new HashMap<>(), response -> {
            Log.wtf("repo", response.toString());
            if (response != null) {
                emitter.onSuccess(response);
            } else {
                emitter.onError(new Throwable("Error reaching server"));
            }
        }, error -> {
            Log.wtf("repo", error.getMessage());
            emitter.onError(error);
        })));
    }


}
