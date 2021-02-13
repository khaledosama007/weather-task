package task.android.com.weatherapp.presentation.viewmodel;

import android.annotation.SuppressLint;

import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModel;

import org.reactivestreams.Subscription;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class BaseViewModel extends ViewModel {

    private final Scheduler subscribeOn;
    private final Scheduler observeOn;
    private final CompositeDisposable disposables;

    public BaseViewModel(Scheduler subscribeOn, Scheduler observeOn) {
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
        this.disposables = new CompositeDisposable();
    }
    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    @SuppressLint("RestrictedApi")
    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        dispose();
    }
}
