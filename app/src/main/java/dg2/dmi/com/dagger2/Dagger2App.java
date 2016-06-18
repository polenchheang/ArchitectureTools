package dg2.dmi.com.dagger2;

import android.app.Application;


/**
 * Created by gguser on 1/29/16.
 */
public class Dagger2App extends Application {

    public String getBaseUrl() {
        return BuildConfig.ENDPOINT;
    }

}
