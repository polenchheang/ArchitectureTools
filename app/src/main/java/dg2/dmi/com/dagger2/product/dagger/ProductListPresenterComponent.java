package dg2.dmi.com.dagger2.product.dagger;

import dagger.Component;
import dg2.dmi.com.dagger2.activity.MainActivity;
import dg2.dmi.com.dagger2.dagger.scope.ProductListScope;
import dg2.dmi.com.dagger2.product.interfaces.ProductListApi;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

/**
 * Created by polenchheang on 5/29/16.
 */
@ProductListScope
@Component(
        dependencies = ProductListModelComponent.class,
        modules = {
                ProductListPresenterModule.class
        }
)
public interface ProductListPresenterComponent {
    void inject(MainActivity activity);
    ProductListApi getGitHubInterface();
    ProductListPresenter getPresenter();
}
