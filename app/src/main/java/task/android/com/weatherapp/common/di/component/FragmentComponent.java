package task.android.com.weatherapp.common.di.component;

import dagger.Component;
import task.android.com.weatherapp.common.di.scope.FragmentScope;
import task.android.com.weatherapp.ui.currentCity.CurrentCity;
import task.android.com.weatherapp.ui.mainWeatherFragment.MainFragment;


@FragmentScope
@Component(dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject (CurrentCity fragment);

    void inject (MainFragment fragment);

}
