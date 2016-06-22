package dg2.dmi.com.dagger2.product.productList.di.component;

import dagger.Component;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListViewModule;
import dg2.dmi.com.dagger2.product.productList.di.scope.ViewScope;
import dg2.dmi.com.dagger2.product.productList.inteface.View;

/**
 * Created by polenchheang on 6/18/16.
 */
@ViewScope
@Component(
        dependencies = PresenterComponent.class,
        modules = ProductListViewModule.class
)
public interface ViewComponent {
    View provideView();
}
