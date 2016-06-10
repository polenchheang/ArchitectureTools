package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.product.interfaces.ProductListApi;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.ModelImpl;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.di.scope.ProductListScope;

/**
 * Created by gguser on 6/10/16.
 */
@Module
public class ModelModule {

    @Provides
    @ProductListScope
    public Model provideProductListModel(Presenter presenter, ProductListApi api) {
        Model model = new ModelImpl(api);
        presenter.bind(model);
        return model;
    }
}
