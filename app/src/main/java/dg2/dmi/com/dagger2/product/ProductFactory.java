package dg2.dmi.com.dagger2.product;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

import dg2.dmi.com.dagger2.AppHelper;
import dg2.dmi.com.dagger2.dagger.AppModule;
import dg2.dmi.com.dagger2.dagger.NetModule;
import dg2.dmi.com.dagger2.product.productList.di.component.DaggerProductListComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.DaggerProductListNullObjectComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.DaggerProductListViewComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.ProductListComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.ProductListNullObjectComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.ProductListViewComponent;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListModule;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListNullObjectModule;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListViewModule;

/**
 * Created by gguser on 6/10/16.
 */

public class ProductFactory {
    public static ProductListComponent getProductListComponent(FragmentActivity activity) {
        ProductListComponent cachedProductListComponent = getCachedPresenterComponent(activity);

        ProductListComponent returnComponent;
        if (cachedProductListComponent == null) {
            returnComponent = newInstancePresenterComponent(activity);
        } else {
            returnComponent = cachedProductListComponent;
        }

        return returnComponent;
    }

    public static ProductListViewComponent getProductListView(FragmentActivity activity,ProductListComponent productListComponent) {
        return DaggerProductListViewComponent.builder()
                .productListComponent(productListComponent)
                .productListViewModule(new ProductListViewModule(getRootView(activity)))
                .build();
    }

    public static ProductListNullObjectComponent getNullObjectComponent() {
        return DaggerProductListNullObjectComponent.builder()
                .productListNullObjectModule(new ProductListNullObjectModule()).build();
    }

    private static ProductListComponent newInstancePresenterComponent(FragmentActivity activity) {
        Context context = activity.getBaseContext();

        return DaggerProductListComponent
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

    private static ProductListComponent getCachedPresenterComponent(FragmentActivity activity) {
        return (ProductListComponent) activity
                .getLastCustomNonConfigurationInstance();
    }

    private static ViewGroup getRootView(FragmentActivity activity) {
        return (ViewGroup) activity.findViewById(android.R.id.content);
    }


}
