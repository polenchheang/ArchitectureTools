package dg2.dmi.com.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gguser on 1/29/16.
 */

@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides @AppScope public Context provideAppContext() {
        return mContext;
    }

    @Provides public DummyObject provideDummyObject() {
        return new DummyObject("Not Test");
    }
}
