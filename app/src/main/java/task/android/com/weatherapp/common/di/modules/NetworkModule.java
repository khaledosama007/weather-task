package task.android.com.weatherapp.common.di.modules;


import android.content.Context;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import task.android.com.weatherapp.data.remote.client.APIClient;
import task.android.com.weatherapp.data.remote.client.SettingsAPI;


@Module
public class NetworkModule {
    private SettingsAPI settingsAPI;

   

    @Provides
    SettingsAPI prSettingsAPI() {
        return new SettingsAPI();
    }

    @Provides
    APIClient provideAPIClient(Context context ){
        return APIClient.getInstance(context);
    }
}
