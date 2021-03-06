package dg2.dmi.com.dagger2.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.di.scope.AppScope;

/**
 * Created by gguser on 1/29/16.
 */

@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides @AppScope
    public Context provideAppContext() {
        return mContext;
    }

    @Provides
    public Application provideApplication() {
        return (Application) mContext.getApplicationContext();
    }

}
