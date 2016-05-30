package dg2.dmi.com.dagger2.dagger;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.dagger.scope.ProductListScope;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

/**
 * Created by polenchheang on 5/29/16.
 */
@Module
public class ProductListModule {

    @Provides
    @ProductListScope
    ProductListPresenter providePresenter(GitHubModule.GitHubInterface gitHubInterface) {
        Log.d("Me","providePresenter");
        return new ProductListPresenter(gitHubInterface);
    }
}
