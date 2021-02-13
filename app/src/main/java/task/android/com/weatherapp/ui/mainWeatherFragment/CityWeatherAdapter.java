package task.android.com.weatherapp.ui.mainWeatherFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import task.android.com.weatherapp.R;
import task.android.com.weatherapp.data.remote.model.CityWeather;
import task.android.com.weatherapp.databinding.RowCityRecyclerBinding;

public class CityWeatherAdapter extends RecyclerView.Adapter<CityWeatherAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List<CityWeather> cityWeatherList = new ArrayList<>();

    public CityWeatherAdapter(Context mContext, List<CityWeather> cityWeatherList) {
        this.mContext = mContext;
        this.cityWeatherList = cityWeatherList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowCityRecyclerBinding binding = RowCityRecyclerBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.binding.textViewCityName.setText(String.format(mContext.getString(R.string.recyclerRow_cityName) , cityWeatherList.get(position).getName()));
        holder.binding.textViewTempMin.setText(String.format(mContext.getString(R.string.recyclerRow_minTemp) , cityWeatherList.get(position).getMain().getTempMin().toString()));
        holder.binding.textViewTempMax.setText(String.format(mContext.getString(R.string.maxTemp) , cityWeatherList.get(position).getMain().getTempMax().toString()));
        holder.binding.textViewWeatherDescription.setText(String.format(mContext.getString(R.string.recyclerRow_description) , cityWeatherList.get(position).getWeather().get(0).getDescription()));
        holder.binding.textViewWindSpeed.setText(String.format(mContext.getString(R.string.recyclerRow_windSpeed) , cityWeatherList.get(position).getWind().getSpeed().toString()));
    }

    @Override
    public int getItemCount() {
        return cityWeatherList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private RowCityRecyclerBinding binding;
        public RecyclerViewHolder(RowCityRecyclerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
