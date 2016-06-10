package dg2.dmi.com.dagger2.product.productList.di.component;

import dagger.Component;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.di.module.ModelModule;
import dg2.dmi.com.dagger2.product.productList.di.module.PresenterModule;
import dg2.dmi.com.dagger2.product.productList.di.scope.ProductListScope;

/**
 * Created by gguser on 6/10/16.
 */
@ProductListScope
@Component(modules = {
        PresenterModule.class,
        ModelModule.class
}
)
public interface PresenterComponent {
    Presenter getPresenter();
    Model getMo
}
