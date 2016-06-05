package dg2.dmi.com.dagger2.product.dagger;

import dg2.dmi.com.dagger2.Dagger2App;
import dg2.dmi.com.dagger2.activity.MainActivity;

/**
 * Created by gguser on 5/31/16.
 */

public class ProductListInjectable {
    private static ProductListPresenterComponent sProductListComponent;

    public static void inject(MainActivity activity) {
        if (sProductListComponent == null) {
            sProductListComponent = DaggerProductListPresenterComponent.builder()
                    .productListModelComponent(
                            ((Dagger2App)activity.getApplication()).getGitHubComponent()
                    )
                    .productListPresenterModule(
                            new ProductListPresenterModule()
                    )
                    .build();
        }

        sProductListComponent.inject(activity);
    }

    public static void release(boolean isConfigurationChanged) {
        if (isConfigurationChanged) {
            sProductListComponent.getPresenter().unBind();
        } else {
            sProductListComponent = null;
        }
    }
}
