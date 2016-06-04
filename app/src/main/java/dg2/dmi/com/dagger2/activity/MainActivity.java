package dg2.dmi.com.dagger2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.dagger.ProductListInjectable;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.fab)
    void onRefresh() {
        mPresenter.getProduct();
    }

    @Inject
    ProductListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ProductListInjectable.inject(this);
        mPresenter.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ProductListInjectable.release(isChangingConfigurations());
    }
}
