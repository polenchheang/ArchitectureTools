package dg2.dmi.com.dagger2.product.productList.di.component;

import dagger.Component;
import dg2.dmi.com.dagger2.product.productList.View;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListViewModule;
import dg2.dmi.com.dagger2.product.productList.di.scope.MainActivityScope;

/**
 * Created by polenchheang on 6/18/16.
 */
@MainActivityScope
@Component(dependencies = ProductListComponent.class
        , modules = ProductListViewModule.class)
public interface ProductListViewComponent {
    View provideView();
}
