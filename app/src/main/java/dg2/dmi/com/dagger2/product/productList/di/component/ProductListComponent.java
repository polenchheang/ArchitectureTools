package dg2.dmi.com.dagger2.product.productList.di.component;

import dagger.Component;
import dg2.dmi.com.dagger2.activity.ProductListActivity;
import dg2.dmi.com.dagger2.di.module.AppModule;
import dg2.dmi.com.dagger2.di.module.NetModule;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListModule;
import dg2.dmi.com.dagger2.product.productList.di.scope.ProductListScope;

/**
 * Created by gguser on 6/10/16.
 */
@ProductListScope
@Component(modules = {
        ProductListModule.class,
        NetModule.class,
        AppModule.class
    }
)
public interface ProductListComponent {
    void inject(ProductListActivity activity);
    Presenter getPresenter();
}
