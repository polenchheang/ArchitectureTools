package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.product.productList.Api;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.di.scope.ProductListScope;
import dg2.dmi.com.dagger2.product.productList.implement.ApiAsyncImpl;
import dg2.dmi.com.dagger2.product.productList.implement.ModelImpl;
import dg2.dmi.com.dagger2.product.productList.implement.PresenterImpl;
import retrofit2.Retrofit;

/**
 * Created by gguser on 6/10/16.
 */
@Module
public class ProductListModule {

    @Provides
    @ProductListScope
    public Presenter providePresenter(Model model) {
        Presenter presenter = new PresenterImpl();
        presenter.bind(model);
        return presenter;
    }

    @Provides
    @ProductListScope
    public Model provideProductListModel(Api api) {
        return new ModelImpl(api);
    }

    @Provides
    @ProductListScope
    public Api provideProductListApi(Retrofit retrofit) {
        return new ApiAsyncImpl(retrofit);
    }

}
