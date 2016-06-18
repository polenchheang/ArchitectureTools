package dg2.dmi.com.dagger2.product.productList.di.component;

import dagger.Component;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.ModelEventListener;
import dg2.dmi.com.dagger2.product.productList.View;
import dg2.dmi.com.dagger2.product.productList.ViewEventListener;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListNullObjectModule;
import dg2.dmi.com.dagger2.product.productList.implement.ModelImpl;
import dg2.dmi.com.dagger2.product.productList.implement.PresenterImpl;
import dg2.dmi.com.dagger2.product.productList.implement.ViewImpl;

/**
 * Created by polenchheang on 6/14/16.
 */

@Component(
        modules = ProductListNullObjectModule.class
)
public interface ProductListNullObjectComponent {
    void inject(PresenterImpl presenter);
    void inject(ViewImpl view);
    void inject(ModelImpl model);
    View getNullView();
    Model getNullModel();
    ModelEventListener getNullModelEventListener();
    ViewEventListener getNullViewEventListener();
}
