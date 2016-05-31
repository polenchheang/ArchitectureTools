package dg2.dmi.com.dagger2.product.dagger;

import dagger.Component;
import dg2.dmi.com.dagger2.activity.MainActivity;
import dg2.dmi.com.dagger2.dagger.GitHubComponent;
import dg2.dmi.com.dagger2.dagger.GitHubModule;
import dg2.dmi.com.dagger2.dagger.scope.ProductListScope;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

/**
 * Created by polenchheang on 5/29/16.
 */
@ProductListScope
@Component(
        dependencies = GitHubComponent.class,
        modules = {
                ProductListPresenterModule.class
        }
)
public interface ProductListPresenterComponent {
    void inject(MainActivity activity);
    GitHubModule.GitHubInterface getGitHubInterface();
    ProductListPresenter getPresenter();
}
