package dg2.dmi.com.dagger2.dagger;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by gguser on 4/18/16.
 */
@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    OkHttpClient okHttpClient();
}
