package task.android.com.weatherapp.common.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import task.android.com.weatherapp.common.provider.scheduler.AppSchedulerProvider;
import task.android.com.weatherapp.data.repository.WeatherRepository;
import task.android.com.weatherapp.presentation.viewmodel.WeatherViewModel;
import task.android.com.weatherapp.presentation.viewmodel.factory.ViewModelFactory;


@Module(includes = {AppModule.class})
public abstract class ViewModelModule {

    @Provides
    static WeatherViewModel provided(WeatherRepository repository, AppSchedulerProvider appSchedulerProvider) {
        return new WeatherViewModel(appSchedulerProvider,repository);
    }
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel.class)
    abstract ViewModel provideWeatherViewModel(WeatherViewModel weatherViewModel);
}
