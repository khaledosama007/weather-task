package task.android.com.weatherapp.common.provider.scheduler;

import io.reactivex.Scheduler;



public interface SchedulerProvider {

    Scheduler ui();

    Scheduler io();

}
