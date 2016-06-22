package dg2.dmi.com.dagger2.product.productList.factory;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

import dg2.dmi.com.dagger2.AppHelper;
import dg2.dmi.com.dagger2.di.module.AppModule;
import dg2.dmi.com.dagger2.di.module.NetModule;
import dg2.dmi.com.dagger2.product.productList.di.component.DaggerNullObjectComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.DaggerPresenterComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.DaggerViewComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.NullObjectComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.PresenterComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.ViewComponent;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListModule;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListNullObjectModule;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListViewModule;

/**
 * Created by polenchheang on 6/20/16.
 */

class ComponentFactory {
    static PresenterComponent getPresenterComponent(Context context) {
        return DaggerPresenterComponent
                .builder()
                .appModule(
                        new AppModule(context)
                )
                .netModule(
                        new NetModule(
                                AppHelper.getBaseUrl(context)
                        )
                )
                .productListModule(
                        new ProductListModule()
                )
                .build();
    }

    static PresenterComponent getCachedPresenterComponent(FragmentActivity activity) {
        return (PresenterComponent) activity.getLastCustomNonConfigurationInstance();
    }

    static ViewComponent getViewComponent(FragmentActivity activity,
                                          PresenterComponent presenterComponent) {
        return DaggerViewComponent.builder()
                .presenterComponent(presenterComponent)
                .productListViewModule(new ProductListViewModule(
                        (ViewGroup) activity.findViewById(android.R.id.content))
                )
                .build();
    }

    static NullObjectComponent getNullObjectComponent() {
        return DaggerNullObjectComponent.builder()
                .productListNullObjectModule(new ProductListNullObjectModule()).build();
    }

}
