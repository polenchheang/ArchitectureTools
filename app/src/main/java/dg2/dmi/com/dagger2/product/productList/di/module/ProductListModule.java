package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.product.productList.inteface.Api;
import dg2.dmi.com.dagger2.product.productList.inteface.Model;
import dg2.dmi.com.dagger2.product.productList.inteface.Presenter;
import dg2.dmi.com.dagger2.product.productList.di.scope.PresenterScope;
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
    @PresenterScope
    public Presenter providePresenter(Model model) {
        Presenter presenter = new PresenterImpl();
        presenter.bind(model);
        return presenter;
    }

    @Provides
    @PresenterScope
    public Model provideProductListModel(Api api) {
        return new ModelImpl(api);
    }

    @Provides
    @PresenterScope
    public Api provideProductListApi(Retrofit retrofit) {
        return new ApiAsyncImpl(retrofit);
    }

}
