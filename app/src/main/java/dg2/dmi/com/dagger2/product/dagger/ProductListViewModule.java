package dg2.dmi.com.dagger2.product.dagger;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.activity.MainActivity;
import dg2.dmi.com.dagger2.product.ProductListView;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

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
    ProductListPresenter.Callback provideView() {
        Log.d("Me","provideView");
        RecyclerView recyclerView = (RecyclerView) mMainActivity.findViewById(R.id.my_recycler_view);
        return new ProductListView(recyclerView);
    }
}
