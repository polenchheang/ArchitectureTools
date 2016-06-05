package dg2.dmi.com.dagger2.product.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.product.interfaces.ProductListApi;
import retrofit2.Retrofit;

/**
 * Created by gguser on 4/18/16.
 */
@Module
public class ProductListModelModule {

    @Provides
    @Singleton
    public ProductListApi provideGitHubInterface(Retrofit retrofit) {
        return retrofit.create(ProductListApi.class);
    }
}
