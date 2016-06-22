package dg2.dmi.com.dagger2.product.productList.di.module;

import android.view.ViewGroup;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.product.productList.inteface.Presenter;
import dg2.dmi.com.dagger2.product.productList.inteface.View;
import dg2.dmi.com.dagger2.product.productList.di.scope.ViewScope;
import dg2.dmi.com.dagger2.product.productList.implement.ViewImpl;

/**
 * Created by polenchheang on 6/18/16.
 */
@Module
public class ProductListViewModule {
    private ViewGroup mRootView;

    public ProductListViewModule(ViewGroup rootView) {
        this.mRootView = rootView;
    }

    @Provides
    @ViewScope
    public View provideProductListView(Presenter presenter) {
        View view = new ViewImpl(mRootView);
        presenter.bind(view);
        return view;
    }
}
