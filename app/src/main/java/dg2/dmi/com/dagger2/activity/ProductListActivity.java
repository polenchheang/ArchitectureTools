package dg2.dmi.com.dagger2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.ProductFactory;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.di.component.ProductListComponent;
import dg2.dmi.com.dagger2.product.productList.di.component.ProductListViewComponent;

public class ProductListActivity extends AppCompatActivity {

    private ProductListComponent mProductListComponent;
    private ProductListViewComponent mProductListViewComponent;

    @Inject
    Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mProductListComponent = ProductFactory.getProductListComponent(this);
        mProductListComponent.inject(this);

        getViewComponent();

        setSupportActionBar(
                (Toolbar) findViewById(R.id.toolbar)
        );
    }

    private void getViewComponent() {
        mProductListViewComponent = ProductFactory.getProductListView(this,mProductListComponent);
        mProductListViewComponent.provideView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mProductListViewComponent == null) {
            getViewComponent();
        }
    }

    @Override
    public ProductListComponent onRetainCustomNonConfigurationInstance() {
        return mProductListComponent;
    }

    @Override
    protected void onPause() {
        mPresenter.releaseView();
        if (!isChangingConfigurations()) {
            mPresenter.releaseModel();
        }
        mProductListViewComponent = null;
        super.onPause();
    }
}
