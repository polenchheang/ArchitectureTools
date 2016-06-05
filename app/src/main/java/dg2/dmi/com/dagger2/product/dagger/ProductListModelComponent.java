package dg2.dmi.com.dagger2.product.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dg2.dmi.com.dagger2.dagger.NetComponent;
import dg2.dmi.com.dagger2.product.interfaces.ProductListApi;

/**
 * Created by gguser on 4/18/16.
 */
@Singleton
@Component(
        dependencies = NetComponent.class,
        modules = {
                ProductListModelModule.class
        }
)
public interface ProductListModelComponent {
//    void inject(MainActivity activity);
    ProductListApi getProductListModel();
}
