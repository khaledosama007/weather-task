package task.android.com.weatherapp.data.remote.client;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class APIClient {

    private static APIClient apiClient;
    private SettingsAPI settings;
    private RequestQueue requestQueue;
    private Context context;
    public static APIClient getInstance(Context context) {
        if (apiClient == null)
            apiClient = new APIClient(new SettingsAPI() , context);
        return apiClient;
    }

    private APIClient(SettingsAPI settings , Context context) {
        this.settings = settings;
        this.context = context;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }


}
