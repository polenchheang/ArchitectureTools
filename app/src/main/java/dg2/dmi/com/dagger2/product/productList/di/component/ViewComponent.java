package dg2.dmi.com.dagger2.product.productList.di.component;

import android.view.ViewGroup;

import javax.inject.Singleton;

import dagger.Component;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.View;
import dg2.dmi.com.dagger2.product.productList.di.module.ViewModule;

/**
 * Created by gguser on 6/10/16.
 */
@Singleton
@Component(
        dependencies = PresenterComponent.class,
        modules = ViewModule.class
)
public interface ViewComponent {
    View getView(Presenter presenter,ViewGroup root);
}
