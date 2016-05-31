package dg2.dmi.com.dagger2.product.dagger;

import dagger.Component;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

/**
 * Created by polenchheang on 5/29/16.
 */
@Component(
        modules = {
                ProductListViewModule.class
        }
)
public interface ProductListViewComponent {
    void inject(ProductListPresenter presenter);
    ProductListPresenter.Callback getProductListView();
}
