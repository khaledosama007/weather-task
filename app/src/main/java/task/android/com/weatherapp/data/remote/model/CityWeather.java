package task.android.com.weatherapp.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityWeather {
    public final static Parcelable.Creator<CityWeather> CREATOR = new Parcelable.Creator<CityWeather>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CityWeather createFromParcel(Parcel in) {
            return new CityWeather(in);
        }

        public CityWeather[] newArray(int size) {
            return (new CityWeather[size]);
        }

    };
    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private MainWeather main;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("timezone")
    @Expose
    private Integer timezone;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

    protected CityWeather(Parcel in) {
        this.coord = ((Coord) in.readValue((Coord.class.getClassLoader())));
        in.readList(this.weather, (Weather.class.getClassLoader()));
        this.base = ((String) in.readValue((String.class.getClassLoader())));
        this.main = ((MainWeather) in.readValue((MainWeather.class.getClassLoader())));
        this.visibility = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
        this.clouds = ((Clouds) in.readValue((Clouds.class.getClassLoader())));
        this.dt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sys = ((Sys) in.readValue((Sys.class.getClassLoader())));
        this.timezone = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.cod = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public CityWeather() {
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainWeather getMain() {
        return main;
    }

    public void setMain(MainWeather main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(coord);
        dest.writeList(weather);
        dest.writeValue(base);
        dest.writeValue(main);
        dest.writeValue(visibility);
        dest.writeValue(wind);
        dest.writeValue(clouds);
        dest.writeValue(dt);
        dest.writeValue(sys);
        dest.writeValue(timezone);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(cod);
    }

    public int describeContents() {
        return 0;
    }

    public static class Clouds implements Parcelable {

        public final static Parcelable.Creator<Clouds> CREATOR = new Creator<Clouds>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Clouds createFromParcel(Parcel in) {
                return new Clouds(in);
            }

            public Clouds[] newArray(int size) {
                return (new Clouds[size]);
            }

        };
        @SerializedName("all")
        @Expose
        private Integer all;

        protected Clouds(Parcel in) {
            this.all = ((Integer) in.readValue((Integer.class.getClassLoader())));
        }

        public Clouds() {
        }

        public Integer getAll() {
            return all;
        }

        public void setAll(Integer all) {
            this.all = all;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(all);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Coord implements Parcelable {

        public final static Parcelable.Creator<Coord> CREATOR = new Creator<Coord>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Coord createFromParcel(Parcel in) {
                return new Coord(in);
            }

            public Coord[] newArray(int size) {
                return (new Coord[size]);
            }

        };
        @SerializedName("lon")
        @Expose
        private Double lon;
        @SerializedName("lat")
        @Expose
        private Double lat;

        protected Coord(Parcel in) {
            this.lon = ((Double) in.readValue((Double.class.getClassLoader())));
            this.lat = ((Double) in.readValue((Double.class.getClassLoader())));
        }

        public Coord() {
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(lon);
            dest.writeValue(lat);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class MainWeather implements Parcelable {

        public final static Parcelable.Creator<MainWeather> CREATOR = new Creator<MainWeather>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public MainWeather createFromParcel(Parcel in) {
                return new MainWeather(in);
            }

            public MainWeather[] newArray(int size) {
                return (new MainWeather[size]);
            }

        };
        @SerializedName("temp")
        @Expose
        private Double temp;
        @SerializedName("feels_like")
        @Expose
        private Double feelsLike;
        @SerializedName("temp_min")
        @Expose
        private Double tempMin;
        @SerializedName("temp_max")
        @Expose
        private Double tempMax;
        @SerializedName("pressure")
        @Expose
        private Double pressure;
        @SerializedName("humidity")
        @Expose
        private Double humidity;

        protected MainWeather(Parcel in) {
            this.temp = ((Double) in.readValue((Double.class.getClassLoader())));
            this.feelsLike = ((Double) in.readValue((Double.class.getClassLoader())));
            this.tempMin = ((Double) in.readValue((Integer.class.getClassLoader())));
            this.tempMax = ((Double) in.readValue((Double.class.getClassLoader())));
            this.pressure = ((Double) in.readValue((Integer.class.getClassLoader())));
            this.humidity = ((Double) in.readValue((Integer.class.getClassLoader())));
        }

        public MainWeather() {
        }

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(Double feelsLike) {
            this.feelsLike = feelsLike;
        }

        public Double getTempMin() {
            return tempMin;
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTempMax() {
            return tempMax;
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(temp);
            dest.writeValue(feelsLike);
            dest.writeValue(tempMin);
            dest.writeValue(tempMax);
            dest.writeValue(pressure);
            dest.writeValue(humidity);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Sys implements Parcelable {

        public final static Parcelable.Creator<Sys> CREATOR = new Creator<Sys>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Sys createFromParcel(Parcel in) {
                return new Sys(in);
            }

            public Sys[] newArray(int size) {
                return (new Sys[size]);
            }

        };
        @SerializedName("type")
        @Expose
        private Integer type;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("sunrise")
        @Expose
        private Integer sunrise;
        @SerializedName("sunset")
        @Expose
        private Integer sunset;

        protected Sys(Parcel in) {
            this.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.country = ((String) in.readValue((String.class.getClassLoader())));
            this.sunrise = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.sunset = ((Integer) in.readValue((Integer.class.getClassLoader())));
        }

        public Sys() {
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getSunrise() {
            return sunrise;
        }

        public void setSunrise(Integer sunrise) {
            this.sunrise = sunrise;
        }

        public Integer getSunset() {
            return sunset;
        }

        public void setSunset(Integer sunset) {
            this.sunset = sunset;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(type);
            dest.writeValue(id);
            dest.writeValue(country);
            dest.writeValue(sunrise);
            dest.writeValue(sunset);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Weather implements Parcelable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;
        public final static Parcelable.Creator<Weather> CREATOR = new Creator<Weather>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Weather createFromParcel(Parcel in) {
                return new Weather(in);
            }

            public Weather[] newArray(int size) {
                return (new Weather[size]);
            }

        };

        protected Weather(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.main = ((String) in.readValue((String.class.getClassLoader())));
            this.description = ((String) in.readValue((String.class.getClassLoader())));
            this.icon = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Weather() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(main);
            dest.writeValue(description);
            dest.writeValue(icon);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Wind implements Parcelable {

        @SerializedName("speed")
        @Expose
        private Double speed;
        @SerializedName("deg")
        @Expose
        private Double deg;
        public final static Parcelable.Creator<Wind> CREATOR = new Creator<Wind>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Wind createFromParcel(Parcel in) {
                return new Wind(in);
            }

            public Wind[] newArray(int size) {
                return (new Wind[size]);
            }

        };

        protected Wind(Parcel in) {
            this.speed = ((Double) in.readValue((Double.class.getClassLoader())));
            this.deg = ((Double) in.readValue((Integer.class.getClassLoader())));
        }

        public Wind() {
        }

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public Double getDeg() {
            return deg;
        }

        public void setDeg(Double deg) {
            this.deg = deg;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(speed);
            dest.writeValue(deg);
        }

        public int describeContents() {
            return 0;
        }

    }
}

