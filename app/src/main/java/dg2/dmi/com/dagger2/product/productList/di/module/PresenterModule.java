package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.PresenterImpl;
import dg2.dmi.com.dagger2.product.productList.di.scope.ProductListScope;

/**
 * Created by gguser on 6/10/16.
 */
@Module
public class PresenterModule {

    @Provides
    @ProductListScope
    public Presenter providePresenter() {
        return new PresenterImpl();
    }
}
