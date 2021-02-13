package task.android.com.weatherapp.ui.currentCity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import task.android.com.weatherapp.R;
import task.android.com.weatherapp.data.remote.model.CityForecast;
import task.android.com.weatherapp.databinding.ForecastListGroupBinding;
import task.android.com.weatherapp.databinding.RowCityRecyclerBinding;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> listHeaders = new ArrayList<>();
    private HashMap<String , List<CityForecast.WeatherList>> contentList = new HashMap<>();

    public ExpandableListAdapter(Context mContext, List<String> listHeaders, HashMap<String, List<CityForecast.WeatherList>> contentList) {
        this.mContext = mContext;
        this.listHeaders = listHeaders;
        this.contentList = contentList;
    }

    @Override
    public int getGroupCount() {
        return listHeaders.size();
    }

    @Override
    public int getChildrenCount(int group) {
        return contentList.get(listHeaders.get(group)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listHeaders.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return contentList.get(listHeaders.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        final ForecastListGroupBinding binding;
        if (convertView == null) {
            binding = ForecastListGroupBinding.inflate((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE),parent , false );
            convertView = binding.getRoot();

        }else
            binding = (ForecastListGroupBinding) convertView.getTag();
        binding.forecastGroupName.setText(headerTitle);
        convertView.setTag(binding);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final int index = groupPosition;
        CityForecast.WeatherList list  = (CityForecast.WeatherList) getChild(groupPosition , childPosition);
        final RowCityRecyclerBinding childBinding;
        if(convertView == null) {
            childBinding = RowCityRecyclerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            convertView = childBinding.getRoot();
        }
        else {
            childBinding = (RowCityRecyclerBinding) convertView.getTag();
        }
        childBinding.textViewCityName.setText(String.format(mContext.getString(R.string.recyclerRow_cityName) , list.getDtTxt().split(" ")[1]));
        childBinding.textViewTempMin.setText(String.format(mContext.getString(R.string.recyclerRow_minTemp) , list.getMain().getTempMin().toString()));
        childBinding.textViewTempMax.setText(String.format(mContext.getString(R.string.maxTemp) , list.getMain().getTempMax().toString()));
        childBinding.textViewWeatherDescription.setText(String.format(mContext.getString(R.string.recyclerRow_description) , list.getWeather().get(0).getDescription()));
        childBinding.textViewWindSpeed.setText(String.format(mContext.getString(R.string.recyclerRow_windSpeed) , list.getWind().getSpeed().toString()));
        convertView.setTag(childBinding);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
