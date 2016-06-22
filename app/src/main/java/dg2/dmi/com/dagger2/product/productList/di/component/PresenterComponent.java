package dg2.dmi.com.dagger2.product.productList.di.component;

import dg2.dmi.com.dagger2.activity.ProductListActivity;
import dg2.dmi.com.dagger2.di.module.AppModule;
import dg2.dmi.com.dagger2.di.module.NetModule;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListModule;
import dg2.dmi.com.dagger2.product.productList.di.scope.PresenterScope;
import dg2.dmi.com.dagger2.product.productList.inteface.Presenter;

/**
 * Created by gguser on 6/10/16.
 */
@PresenterScope
@dagger.Component(modules = {
        ProductListModule.class,
        NetModule.class,
        AppModule.class
    }
)
public interface PresenterComponent {
    void inject(ProductListActivity activity);
    Presenter getPresenter();
}
