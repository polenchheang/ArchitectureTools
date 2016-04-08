package dg2.dmi.com.dagger2.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.domain.DummyObject;

/**
 * Created by gguser on 2/8/16.
 */
@Module
public class TestAppModule {
    private final Context mContext;

    public TestAppModule(Context context) {
        mContext = context.getApplicationContext();
    }

    @Provides @AppScope
    public Context provideAppContext() {
        return mContext;
    }

    @Provides public DummyObject provideDummyObject() {
        return new DummyObject("Is Test");
    }
}
