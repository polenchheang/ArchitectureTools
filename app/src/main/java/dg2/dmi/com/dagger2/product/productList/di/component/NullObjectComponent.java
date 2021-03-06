package dg2.dmi.com.dagger2.product.productList.di.component;

import dagger.Component;
import dg2.dmi.com.dagger2.product.productList.inteface.Model;
import dg2.dmi.com.dagger2.product.productList.inteface.ModelEventListener;
import dg2.dmi.com.dagger2.product.productList.inteface.View;
import dg2.dmi.com.dagger2.product.productList.inteface.ViewEventListener;
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
public interface NullObjectComponent {
    void inject(PresenterImpl presenter);
    void inject(ViewImpl view);
    void inject(ModelImpl model);
    View getNullView();
    Model getNullModel();
    ModelEventListener getNullModelEventListener();
    ViewEventListener getNullViewEventListener();
}
