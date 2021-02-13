package task.android.com.weatherapp.ui.base;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Map;

import task.android.com.weatherapp.R;
import task.android.com.weatherapp.common.utils.ActivityUtils;

import static task.android.com.weatherapp.common.utils.WeatherConstants.STATUS_LAYOUT_DATA;
import static task.android.com.weatherapp.common.utils.WeatherConstants.STATUS_LAYOUT_LOADING;
import static task.android.com.weatherapp.common.utils.WeatherConstants.STATUS_LAYOUT_NO_CONNECTION;
import static task.android.com.weatherapp.common.utils.WeatherConstants.STATUS_LAYOUT_NO_DATA;
import static task.android.com.weatherapp.common.utils.WeatherConstants.STATUS_SNACK_BAR_NO_CONNECTION;


public abstract class BaseFragment extends Fragment {

    public View noDataLayout;
    public View noConnectionLayout;
    public ProgressBar progress_bar;
    protected View rootView;
    public abstract void onCreateView(View view, Bundle savedInstanceState);

    public abstract void setUpObservers();

    public abstract int getLayoutId();



    public void updateScreenStatus(int status) {
        switch (status) {
            case STATUS_LAYOUT_LOADING: {
                ActivityUtils.setVisibility(View.GONE, noConnectionLayout, noDataLayout);
                ActivityUtils.setVisibility(View.VISIBLE, progress_bar);
                break;
            }
            case STATUS_LAYOUT_NO_CONNECTION: {
                ActivityUtils.setVisibility(View.VISIBLE, noConnectionLayout);
                ActivityUtils.setVisibility(View.GONE, noDataLayout, progress_bar);
                break;
            }
            case STATUS_LAYOUT_NO_DATA: {
                ActivityUtils.setVisibility(View.VISIBLE, noDataLayout);
                ActivityUtils.setVisibility(View.GONE, noConnectionLayout, progress_bar);
                break;
            }
            case STATUS_LAYOUT_DATA :{
                ActivityUtils.setVisibility(View.GONE, noConnectionLayout, progress_bar , noDataLayout);
                break;
            }
        }

    }
    public static void showSnack(View mLayout,String messege) {
        Snackbar.make(mLayout, messege,
                Snackbar.LENGTH_SHORT)
                .show();
    }
    @Override
    public void onDestroyView() {
        //because they leak
        noConnectionLayout = null;
        noDataLayout = null;
        super.onDestroyView();
    }
}
