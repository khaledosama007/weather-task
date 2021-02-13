package task.android.com.weatherapp.ui.currentCity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import task.android.com.weatherapp.R;
import task.android.com.weatherapp.app.WeatherApplication;
import task.android.com.weatherapp.common.di.component.DaggerFragmentComponent;
import task.android.com.weatherapp.common.di.component.FragmentComponent;
import task.android.com.weatherapp.common.provider.location.LocationProviderImpl;
import task.android.com.weatherapp.common.utils.Utilities;
import task.android.com.weatherapp.common.utils.WeatherConstants;
import task.android.com.weatherapp.data.remote.model.CityForecast;
import task.android.com.weatherapp.databinding.FragmentCurrentCityBinding;
import task.android.com.weatherapp.presentation.viewmodel.WeatherViewModel;
import task.android.com.weatherapp.presentation.viewmodel.factory.ViewModelFactory;
import task.android.com.weatherapp.ui.base.BaseFragment;
import task.android.com.weatherapp.ui.interfaces.ISuccesReturnLocation;
import task.android.com.weatherapp.ui.mainWeatherFragment.MainFragment;
import timber.log.Timber;

import static task.android.com.weatherapp.common.utils.WeatherConstants.STATUS_LAYOUT_DATA;
import static task.android.com.weatherapp.common.utils.WeatherConstants.STATUS_LAYOUT_NO_DATA;


public class CurrentCity extends BaseFragment implements ISuccesReturnLocation {
    public static final String TAG = MainFragment.class.getSimpleName();
    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 98;
    @Inject
    ViewModelFactory mModelFactory;
    FragmentCurrentCityBinding binding;
    private CityForecast forecast;
    private WeatherViewModel mViewModel;
    private ExpandableListAdapter adapter;
    private List<String> daysStrings = new ArrayList<>();
    private HashMap<String, List<CityForecast.WeatherList>> weatherStringListHashMap = new HashMap<>();
    private String[] PermissionLocation = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};

    public CurrentCity() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
        mViewModel = ViewModelProviders.of(this, mModelFactory).get(WeatherViewModel.class);
    }

    public void checkLocationPermission() {
        if (getActivity() == null) return;
        if (!isPermissionGranted(Manifest.permission.ACCESS_COARSE_LOCATION) ||
                !isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                Utilities.showDialog(getActivity(), getString(R.string.location_permission_dialog_title),
                        getString(R.string.location_permission_prompt),
                        (dialog, i) -> requestPermission(PermissionLocation),
                        (dialog, i) -> {
                            failedLocation();
                            dialog.cancel();
                        });
                Timber.d("checkLocationPermission: ");
            } else {
                requestPermission(PermissionLocation);
            }
        } else {
            Timber.d("Permission granted");
            startLocationUpdates();
        }
    }

    private void filterWeatherList() {
        List<CityForecast.WeatherList> list = forecast.getList();
        String currentDay = list.get(0).getDtTxt().split(" ")[0];
        daysStrings.add(currentDay);
        weatherStringListHashMap.put(currentDay, new ArrayList<>());
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getDtTxt().split(" ")[0].equals(currentDay)) {
                List<CityForecast.WeatherList> currentList = weatherStringListHashMap.get(currentDay);
                currentList.add(list.get(i));
                weatherStringListHashMap.put(currentDay, currentList);
            } else {
                currentDay = list.get(i).getDtTxt().split(" ")[0];
                daysStrings.add(currentDay);
                weatherStringListHashMap.put(currentDay, new ArrayList<>());
            }
        }
    }

    private boolean isPermissionGranted(String permission) {
        if (getActivity() == null) return false;

        return ActivityCompat.checkSelfPermission(getActivity(),
                permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void startLocationUpdates() {
        if (getActivity() == null) return;
        new LocationProviderImpl(this, LocationServices.getFusedLocationProviderClient(getActivity())).getPreferredLocationString();

    }

    private void requestPermission(String[] permissions) {
        requestPermissions(permissions, PERMISSION_ACCESS_COARSE_LOCATION);
    }

    @Override
    public void successLocation(Location deviceLocation) {
        mViewModel.getCityWeatherForecast(String.valueOf(deviceLocation.getLatitude()), String.valueOf(deviceLocation.getLongitude()));
    }

    @Override
    public void failedLocation() {
        showSnack(binding.getRoot(), "Failed to get location");
        updateScreenStatus(STATUS_LAYOUT_NO_DATA);
    }

    @Override
    public void onCreateView(View view, Bundle savedInstanceState) {

    }

    private void initDagger() {
        FragmentComponent component = DaggerFragmentComponent.builder()
                .appComponent((WeatherApplication.getInstance()).getAppComponent())
                .build();
        component.inject(this);
    }

    @Override
    public void setUpObservers() {
        adapter = new ExpandableListAdapter(CurrentCity.this.getContext(), daysStrings, weatherStringListHashMap);
        binding.currentCityList.setAdapter(adapter);
        mViewModel.getCityWeatherForecastLiveData().observe(this, cityForecast -> {
            if (cityForecast != null) {
                updateScreenStatus(STATUS_LAYOUT_DATA);
                this.forecast = cityForecast;
                binding.textViewCurrentCity.setText(cityForecast.getCity().getName()+" : ");
                filterWeatherList();
                adapter.notifyDataSetChanged();
            } else {
                updateScreenStatus(STATUS_LAYOUT_NO_DATA);
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_current_city;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCurrentCityBinding.inflate(inflater, container, false);
        rootView = binding.getRoot();
        super.rootView = binding.getRoot();
        noDataLayout = rootView.findViewById(R.id.no_data_layout);
        noConnectionLayout = rootView.findViewById(R.id.no_connection_layout);
        progress_bar = rootView.findViewById(R.id.progress_bar);
        setUpObservers();
        checkLocationPermission();
        updateScreenStatus(WeatherConstants.STATUS_LAYOUT_LOADING);
        binding.textViewCurrentCity.setText(String.format(getString(R.string.textView_currentCity), "-"));
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}