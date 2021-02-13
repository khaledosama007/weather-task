package task.android.com.weatherapp.app;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDexApplication;

import io.reactivex.plugins.RxJavaPlugins;
import task.android.com.weatherapp.common.di.component.AppComponent;
import task.android.com.weatherapp.common.di.component.DaggerAppComponent;
import task.android.com.weatherapp.common.di.modules.AppModule;


public class WeatherApplication extends MultiDexApplication {
    private static WeatherApplication mInstance;
    private AppComponent mAppComponent;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        RxJavaPlugins.setErrorHandler(throwable -> {});
        mAppComponent = DaggerAppComponent.builder()
//                preferenceUtilsModule(new PreferenceUtilsModule(getInstance()))
                .appModule(new AppModule(getInstance()))
                .build();


    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static synchronized WeatherApplication getInstance() {
        return mInstance;
    }
}