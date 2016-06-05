package dg2.dmi.com.dagger2;

import android.app.Application;
import android.support.annotation.NonNull;

import dg2.dmi.com.dagger2.dagger.AppModule;
import dg2.dmi.com.dagger2.dagger.DaggerNetComponent;
import dg2.dmi.com.dagger2.dagger.NetComponent;
import dg2.dmi.com.dagger2.dagger.NetModule;
import dg2.dmi.com.dagger2.product.dagger.DaggerProductListModelComponent;
import dg2.dmi.com.dagger2.product.dagger.ProductListModelComponent;
import dg2.dmi.com.dagger2.product.dagger.ProductListModelModule;


/**
 * Created by gguser on 1/29/16.
 */
public class Dagger2App extends Application {

    private ProductListModelComponent mProductListModelComponent;

    private void initializeGitHubComponent() {
        NetComponent netComponent = DaggerNetComponent
                .builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(getBaseUrl())).build();

        mProductListModelComponent = DaggerProductListModelComponent
                .builder()
                .netComponent(netComponent)
                .productListModelModule(new ProductListModelModule())
                .build();

    }

    @NonNull
    public String getBaseUrl() {
        return BuildConfig.ENDPOINT;
    }

    public ProductListModelComponent getGitHubComponent() {
        if (mProductListModelComponent == null) {
            initializeGitHubComponent();
        }
        return mProductListModelComponent;
    }

}
