package dg2.dmi.com.dagger2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.productList.factory.ProductFactory;
import dg2.dmi.com.dagger2.product.productList.di.component.PresenterComponent;
import dg2.dmi.com.dagger2.product.productList.inteface.Presenter;
import dg2.dmi.com.dagger2.product.productList.di.component.ViewComponent;

public class ProductListActivity extends AppCompatActivity {

    private PresenterComponent mPresenterComponent;
    private ViewComponent mViewComponent;

    @Inject
    Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mPresenterComponent = ProductFactory.getProductListComponent(this);
        mPresenterComponent.inject(this);

        getViewComponent();

        setSupportActionBar(
                (Toolbar) findViewById(R.id.toolbar)
        );
    }

    private void getViewComponent() {
        mViewComponent = ProductFactory.getProductListView(this, mPresenterComponent);
        mViewComponent.provideView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mViewComponent == null) {
            getViewComponent();
        }
    }

    @Override
    public PresenterComponent onRetainCustomNonConfigurationInstance() {
        return mPresenterComponent;
    }

    @Override
    protected void onPause() {
        mPresenter.releaseView();
        if (!isChangingConfigurations()) {
            mPresenter.releaseModel();
        }
        mViewComponent = null;
        super.onPause();
    }
}
