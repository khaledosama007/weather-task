package task.android.com.weatherapp.ui.mainWeatherFragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import task.android.com.weatherapp.R;
import task.android.com.weatherapp.app.WeatherApplication;
import task.android.com.weatherapp.common.di.component.DaggerFragmentComponent;
import task.android.com.weatherapp.common.di.component.FragmentComponent;
import task.android.com.weatherapp.common.provider.location.LocationProviderImpl;
import task.android.com.weatherapp.common.utils.Utilities;
import task.android.com.weatherapp.common.utils.WeatherConstants;
import task.android.com.weatherapp.data.remote.model.CityWeather;
import task.android.com.weatherapp.databinding.FragmentMainBinding;
import task.android.com.weatherapp.presentation.viewmodel.WeatherViewModel;
import task.android.com.weatherapp.presentation.viewmodel.factory.ViewModelFactory;
import task.android.com.weatherapp.ui.base.BaseFragment;
import task.android.com.weatherapp.ui.interfaces.ISuccesReturnLocation;
import timber.log.Timber;

public class MainFragment extends BaseFragment {
    public static final String TAG = MainFragment.class.getSimpleName();
    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 98;
    @Inject
    ViewModelFactory mModelFactory;
    private CityWeatherAdapter mWeatherAdapter;
    private List<CityWeather> mCityWeatherList = new ArrayList<>();
    private FragmentMainBinding binding;
    private WeatherViewModel mViewModel;
    private String[] PermissionLocation = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};

    public MainFragment() {

        // Required empty public constructor
    }

    private void initDagger() {
        FragmentComponent component = DaggerFragmentComponent.builder()
                .appComponent((WeatherApplication.getInstance()).getAppComponent())
                .build();
        component.inject(this);
    }

    public void failedLocation() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
        mViewModel = ViewModelProviders.of(this, mModelFactory).get(WeatherViewModel.class);
    }

    @Override
    public void onCreateView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void setUpObservers() {
        mWeatherAdapter = new CityWeatherAdapter(MainFragment.this.getContext(), mCityWeatherList);
        binding.cityList.setLayoutManager(new LinearLayoutManager(MainFragment.this.getActivity()));
        binding.cityList.setAdapter(mWeatherAdapter);
        mViewModel.getCityWeatherLiveData().observe(this, cityWeather -> {
            if (cityWeather != null) {
                updateScreenStatus(WeatherConstants.STATUS_LAYOUT_DATA);
                this.mCityWeatherList.clear();
                this.mCityWeatherList.addAll(cityWeather);
                mWeatherAdapter.notifyDataSetChanged();
            } else {
                updateScreenStatus(WeatherConstants.STATUS_LAYOUT_NO_DATA);
            }
        });
        //mViewModel.getCityWeather("cairo");
        binding.editTextCityNames.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_DONE) {
                String[] cities = binding.editTextCityNames.getText().toString().split(",");
                if (cities.length < 3)
                    binding.textInputLayoutCityNames.setError("Please enter at least 3 cities");
                else if (cities.length > 7)
                    binding.textInputLayoutCityNames.setError("Maximum number of cities is 7 ");
                else {
                    updateScreenStatus(WeatherConstants.STATUS_LAYOUT_LOADING);
                    binding.textInputLayoutCityNames.setErrorEnabled(false);
                    mViewModel.getCityWeather(cities);
                }
                return true;
            }
            return false;
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        rootView = binding.getRoot();
        super.rootView = binding.getRoot();
        noDataLayout = rootView.findViewById(R.id.no_data_layout);
        noConnectionLayout = rootView.findViewById(R.id.no_connection_layout);
        progress_bar = rootView.findViewById(R.id.progress_bar);
        setUpObservers();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}