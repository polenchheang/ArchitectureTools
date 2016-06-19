package dg2.dmi.com.dagger2.di.component;

import dagger.Component;
import dg2.dmi.com.dagger2.di.module.AppModule;
import dg2.dmi.com.dagger2.di.module.NetModule;
import retrofit2.Retrofit;

/**
 * Created by gguser on 4/18/16.
 */
@Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
