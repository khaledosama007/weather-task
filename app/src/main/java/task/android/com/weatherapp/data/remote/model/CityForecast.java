package task.android.com.weatherapp.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityForecast {
    public final static Parcelable.Creator<CityForecast> CREATOR = new Parcelable.Creator<CityForecast>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CityForecast createFromParcel(Parcel in) {
            return new CityForecast(in);
        }

        public CityForecast[] newArray(int size) {
            return (new CityForecast[size]);
        }

    };
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Integer message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<WeatherList> list = null;
    @SerializedName("city")
    @Expose
    private City city;

    protected CityForecast(Parcel in) {
        this.cod = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cnt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.list, (WeatherList.class.getClassLoader()));
        this.city = ((City) in.readValue((City.class.getClassLoader())));
    }

    public CityForecast() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<WeatherList> getList() {
        return list;
    }

    public void setList(java.util.List<WeatherList> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);
        dest.writeValue(city);
    }

    public int describeContents() {
        return 0;
    }


    public static class City implements Parcelable {

        public final static Parcelable.Creator<City> CREATOR = new Creator<City>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public City createFromParcel(Parcel in) {
                return new City(in);
            }

            public City[] newArray(int size) {
                return (new City[size]);
            }

        };
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("coord")
        @Expose
        private Coord coord;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("population")
        @Expose
        private Integer population;
        @SerializedName("timezone")
        @Expose
        private Integer timezone;
        @SerializedName("sunrise")
        @Expose
        private Integer sunrise;
        @SerializedName("sunset")
        @Expose
        private Integer sunset;

        protected City(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.name = ((String) in.readValue((String.class.getClassLoader())));
            this.coord = ((Coord) in.readValue((Coord.class.getClassLoader())));
            this.country = ((String) in.readValue((String.class.getClassLoader())));
            this.population = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.timezone = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.sunrise = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.sunset = ((Integer) in.readValue((Integer.class.getClassLoader())));
        }

        public City() {
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

        public Coord getCoord() {
            return coord;
        }

        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getPopulation() {
            return population;
        }

        public void setPopulation(Integer population) {
            this.population = population;
        }

        public Integer getTimezone() {
            return timezone;
        }

        public void setTimezone(Integer timezone) {
            this.timezone = timezone;
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
            dest.writeValue(id);
            dest.writeValue(name);
            dest.writeValue(coord);
            dest.writeValue(country);
            dest.writeValue(population);
            dest.writeValue(timezone);
            dest.writeValue(sunrise);
            dest.writeValue(sunset);
        }

        public int describeContents() {
            return 0;
        }

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
        @SerializedName("lat")
        @Expose
        private Double lat;
        @SerializedName("lon")
        @Expose
        private Double lon;

        protected Coord(Parcel in) {
            this.lat = ((Double) in.readValue((Double.class.getClassLoader())));
            this.lon = ((Double) in.readValue((Double.class.getClassLoader())));
        }

        public Coord() {
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(lat);
            dest.writeValue(lon);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class WeatherList implements Parcelable {

        public final static Parcelable.Creator<WeatherList> CREATOR = new Creator<WeatherList>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public WeatherList createFromParcel(Parcel in) {
                return new WeatherList(in);
            }

            public WeatherList[] newArray(int size) {
                return (new WeatherList[size]);
            }

        };
        @SerializedName("dt")
        @Expose
        private Integer dt;
        @SerializedName("main")
        @Expose
        private MainWeather main;
        @SerializedName("weather")
        @Expose
        private java.util.List<Weather> weather = null;
        @SerializedName("clouds")
        @Expose
        private Clouds clouds;
        @SerializedName("wind")
        @Expose
        private Wind wind;
        @SerializedName("visibility")
        @Expose
        private Double visibility;
        @SerializedName("pop")
        @Expose
        private Double pop;
        @SerializedName("sys")
        @Expose
        private Sys sys;
        @SerializedName("dt_txt")
        @Expose
        private String dtTxt;
        @SerializedName("rain")
        @Expose
        private Rain rain;

        protected WeatherList(Parcel in) {
            this.dt = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.main = ((MainWeather) in.readValue((MainWeather.class.getClassLoader())));
            in.readList(this.weather, (Weather.class.getClassLoader()));
            this.clouds = ((Clouds) in.readValue((Clouds.class.getClassLoader())));
            this.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
            this.visibility = ((Double) in.readValue((Integer.class.getClassLoader())));
            this.pop = ((Double) in.readValue((Integer.class.getClassLoader())));
            this.sys = ((Sys) in.readValue((Sys.class.getClassLoader())));
            this.dtTxt = ((String) in.readValue((String.class.getClassLoader())));
            this.rain = ((Rain) in.readValue((Rain.class.getClassLoader())));
        }

        public WeatherList() {
        }

        public Integer getDt() {
            return dt;
        }

        public void setDt(Integer dt) {
            this.dt = dt;
        }

        public MainWeather getMain() {
            return main;
        }

        public void setMain(MainWeather main) {
            this.main = main;
        }

        public java.util.List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(java.util.List<Weather> weather) {
            this.weather = weather;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public Double getVisibility() {
            return visibility;
        }

        public void setVisibility(Double visibility) {
            this.visibility = visibility;
        }

        public Double getPop() {
            return pop;
        }

        public void setPop(Double pop) {
            this.pop = pop;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        public String getDtTxt() {
            return dtTxt;
        }

        public void setDtTxt(String dtTxt) {
            this.dtTxt = dtTxt;
        }

        public Rain getRain() {
            return rain;
        }

        public void setRain(Rain rain) {
            this.rain = rain;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(dt);
            dest.writeValue(main);
            dest.writeList(weather);
            dest.writeValue(clouds);
            dest.writeValue(wind);
            dest.writeValue(visibility);
            dest.writeValue(pop);
            dest.writeValue(sys);
            dest.writeValue(dtTxt);
            dest.writeValue(rain);
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
        @SerializedName("sea_level")
        @Expose
        private Double seaLevel;
        @SerializedName("grnd_level")
        @Expose
        private Double grndLevel;
        @SerializedName("humidity")
        @Expose
        private Double humidity;
        @SerializedName("temp_kf")
        @Expose
        private Double tempKf;

        protected MainWeather(Parcel in) {
            this.temp = ((Double) in.readValue((Double.class.getClassLoader())));
            this.feelsLike = ((Double) in.readValue((Double.class.getClassLoader())));
            this.tempMin = ((Double) in.readValue((Double.class.getClassLoader())));
            this.tempMax = ((Double) in.readValue((Double.class.getClassLoader())));
            this.pressure = ((Double) in.readValue((Integer.class.getClassLoader())));
            this.seaLevel = ((Double) in.readValue((Integer.class.getClassLoader())));
            this.grndLevel = ((Double) in.readValue((Integer.class.getClassLoader())));
            this.humidity = ((Double) in.readValue((Integer.class.getClassLoader())));
            this.tempKf = ((Double) in.readValue((Integer.class.getClassLoader())));
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

        public Double getSeaLevel() {
            return seaLevel;
        }

        public void setSeaLevel(Double seaLevel) {
            this.seaLevel = seaLevel;
        }

        public Double getGrndLevel() {
            return grndLevel;
        }

        public void setGrndLevel(Double grndLevel) {
            this.grndLevel = grndLevel;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public Double getTempKf() {
            return tempKf;
        }

        public void setTempKf(Double tempKf) {
            this.tempKf = tempKf;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(temp);
            dest.writeValue(feelsLike);
            dest.writeValue(tempMin);
            dest.writeValue(tempMax);
            dest.writeValue(pressure);
            dest.writeValue(seaLevel);
            dest.writeValue(grndLevel);
            dest.writeValue(humidity);
            dest.writeValue(tempKf);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Rain implements Parcelable
    {

        @SerializedName("3h")
        @Expose
        private Double _3h;
        public final static Parcelable.Creator<Rain> CREATOR = new Creator<Rain>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Rain createFromParcel(Parcel in) {
                return new Rain(in);
            }

            public Rain[] newArray(int size) {
                return (new Rain[size]);
            }

        }
                ;

        protected Rain(Parcel in) {
            this._3h = ((Double) in.readValue((Double.class.getClassLoader())));
        }

        public Rain() {
        }

        public Double get3h() {
            return _3h;
        }

        public void set3h(Double _3h) {
            this._3h = _3h;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(_3h);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Sys implements Parcelable
    {

        @SerializedName("pod")
        @Expose
        private String pod;
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

        }
                ;

        protected Sys(Parcel in) {
            this.pod = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Sys() {
        }

        public String getPod() {
            return pod;
        }

        public void setPod(String pod) {
            this.pod = pod;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(pod);
        }

        public int describeContents() {
            return 0;
        }

    }
    public static class Weather implements Parcelable
    {

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

        }
                ;

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
    public static class Wind implements Parcelable
    {

        @SerializedName("speed")
        @Expose
        private Double speed;
        @SerializedName("deg")
        @Expose
        private Integer deg;
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

        }
                ;

        protected Wind(Parcel in) {
            this.speed = ((Double) in.readValue((Double.class.getClassLoader())));
            this.deg = ((Integer) in.readValue((Integer.class.getClassLoader())));
        }

        public Wind() {
        }

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public Integer getDeg() {
            return deg;
        }

        public void setDeg(Integer deg) {
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
