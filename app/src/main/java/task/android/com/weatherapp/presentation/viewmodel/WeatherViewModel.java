package task.android.com.weatherapp.presentation.viewmodel;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import task.android.com.weatherapp.common.provider.scheduler.AppSchedulerProvider;
import task.android.com.weatherapp.data.remote.model.CityForecast;
import task.android.com.weatherapp.data.remote.model.CityWeather;
import task.android.com.weatherapp.data.repository.WeatherRepository;
import timber.log.Timber;

public class WeatherViewModel extends BaseViewModel {
    WeatherRepository weatherRepository;
    private MutableLiveData<List<CityWeather>> cityWeather = new MutableLiveData<>();
    private MutableLiveData<CityForecast> cityWeatherForecast = new MutableLiveData<>();

    public MutableLiveData<CityForecast> getCityWeatherForecastLiveData() {
        return cityWeatherForecast;
    }

    public void setCityWeatherForecastLiveData(MutableLiveData<CityForecast> cityWeatherForecast) {
        this.cityWeatherForecast = cityWeatherForecast;
    }

    public MutableLiveData<List<CityWeather>> getCityWeatherLiveData() {
        return cityWeather;
    }

    public void setCityWeatherLiveData(MutableLiveData<List<CityWeather>> cityWeather) {
        this.cityWeather = cityWeather;
    }

    @Inject
    public WeatherViewModel(AppSchedulerProvider appSchedulerProvider, WeatherRepository weatherRepository) {
        super(appSchedulerProvider.io(), appSchedulerProvider.ui());
        this.weatherRepository = weatherRepository;
    }

    @SuppressLint("CheckResult")
    public void getCityWeather(String[] cityNames) {
        List<Single<CityWeather>> requests = new ArrayList<>();
        for(int i=0 ; i<cityNames.length ; i++){
            requests.add(weatherRepository.getCityWeather(cityNames[i]));
        }
        try {
            Single.zip(requests, objects -> {
                CityWeather[] cities = new CityWeather[objects.length];
                for (int i = 0; i < objects.length; i++) {
                    cities[i] = (CityWeather) objects[i];
                }
                return Arrays.asList(cities);
            }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                    .subscribe(cityWeatherResponse -> {
                        cityWeather.postValue(cityWeatherResponse);
                    }, throwable -> {
                        cityWeather.postValue(null);
                    });
        }catch (Exception e){
            cityWeather.postValue(null);
        }

    }

    @SuppressLint("CheckResult")
    public void getCityWeatherForecast(String lat , String lng){
        weatherRepository.getCityWeatherForecast(lat,lng).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(cityForecast -> {
                    cityWeatherForecast.postValue(cityForecast);
                }, throwable -> {
                    cityWeatherForecast.postValue(null);
                });
    }

}
