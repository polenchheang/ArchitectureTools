package dg2.dmi.com.dagger2.product.dagger;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.dagger.scope.ProductListScope;
import dg2.dmi.com.dagger2.product.interfaces.ProductListApi;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

/**
 * Created by polenchheang on 5/29/16.
 */
@Module
public class ProductListPresenterModule {

    @Provides
    @ProductListScope
    ProductListPresenter providePresenter(ProductListApi productListModel) {
        Log.d("Me","providePresenter");
        return new ProductListPresenter(productListModel);
    }
}
