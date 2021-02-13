package task.android.com.weatherapp.common.di.modules;

import android.content.Context;


import dagger.Module;
import dagger.Provides;
import task.android.com.weatherapp.common.provider.scheduler.AppSchedulerProvider;



@Module
public class AppModule {
    Context context;

    public AppModule(Context mContext) {
        this.context = mContext;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    AppSchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
