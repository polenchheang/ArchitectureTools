package dg2.dmi.com.dagger2.product.productList.di.module;

import android.view.ViewGroup;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.View;
import dg2.dmi.com.dagger2.product.productList.ViewImpl;

/**
 * Created by gguser on 6/10/16.
 */
@Module
public class ViewModule {
    @Provides
    @Singleton
    public View provideProductListView(Presenter presenter, ViewGroup root) {
        View view = new ViewImpl(root);
        presenter.bind(view);
        return view;
    }
}
