package dg2.dmi.com.dagger2.dagger;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.dagger.scope.AppScope;
import dg2.dmi.com.dagger2.domain.DummyObject;

/**
 * Created by gguser on 2/8/16.
 */
@Module
public class TestNetModule extends NetModule {
    public TestNetModule(String baseUrl) {
        super(baseUrl);
    }
}
