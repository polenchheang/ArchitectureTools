package dg2.dmi.com.dagger2.product.dagger;

import android.util.Log;
import android.view.ViewGroup;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.activity.MainActivity;
import dg2.dmi.com.dagger2.product.ProductListView;
import dg2.dmi.com.dagger2.product.interfaces.ProductListCallback;

/**
 * Created by polenchheang on 5/29/16.
 */
@Module
public class ProductListViewModule {

    private MainActivity mMainActivity;

    public ProductListViewModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides
    ProductListCallback provideView() {
        Log.d("Me","provideView");
        return new ProductListView((ViewGroup)mMainActivity.findViewById(android.R.id.content));
    }
}
