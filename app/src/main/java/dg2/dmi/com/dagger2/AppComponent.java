package dg2.dmi.com.dagger2;

import android.content.Context;

import dagger.Component;

/**
 * Created by gguser on 1/29/16.
 */
@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
    @AppScope Context appContext();
    DummyObject dummyObject();
}
