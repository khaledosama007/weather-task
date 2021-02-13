package task.android.com.weatherapp.common.di.component;

import dagger.Component;
import task.android.com.weatherapp.common.di.modules.AppModule;
import task.android.com.weatherapp.common.di.modules.NetworkModule;
import task.android.com.weatherapp.common.di.modules.ViewModelModule;
import task.android.com.weatherapp.common.di.scope.ApplicationScope;
import task.android.com.weatherapp.presentation.viewmodel.factory.ViewModelFactory;


@ApplicationScope
@Component(modules = {AppModule.class, NetworkModule.class,ViewModelModule.class})
public interface AppComponent {


    ViewModelFactory getViewModelFactory();
}
