package dg2.dmi.com.dagger2.product.productList.factory;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import dg2.dmi.com.dagger2.product.productList.di.component.NullObjectComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.PresenterComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.ViewComponent;

/**
 * Created by gguser on 6/10/16.
 */

public class ProductFactory {
    public static PresenterComponent getProductListComponent(FragmentActivity activity) {
        PresenterComponent cachedPresenterComponent = ComponentFactory.
                getCachedPresenterComponent(activity);

        if (cachedPresenterComponent == null) {
            Context context = activity.getBaseContext();
            return ComponentFactory.getPresenterComponent(context);
        } else {
            return cachedPresenterComponent;
        }

    }

    public static ViewComponent getProductListView(FragmentActivity activity,
                                                   PresenterComponent presenterComponent) {
        return ComponentFactory.getViewComponent(activity, presenterComponent);
    }

    public static NullObjectComponent getNullObjectComponent() {
        return ComponentFactory.getNullObjectComponent();
    }




}
