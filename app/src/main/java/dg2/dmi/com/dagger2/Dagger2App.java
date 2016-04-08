package dg2.dmi.com.dagger2;

import android.app.Application;

import dg2.dmi.com.dagger2.dagger.AppComponent;
import dg2.dmi.com.dagger2.dagger.AppModule;
import dg2.dmi.com.dagger2.dagger.DaggerAppComponent;

/**
 * Created by gguser on 1/29/16.
 */
public class Dagger2App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
