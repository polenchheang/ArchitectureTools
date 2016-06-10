package dg2.dmi.com.dagger2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.ProductFactory;
import dg2.dmi.com.dagger2.product.dagger.ProductListInjectable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductListInjectable.inject(this);
        ProductFactory.createProductListPresenter(findViewById(android.R.id.content));

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
        ProductFactory.releaseProductListPresenter(isChangingConfigurations());
        ProductListInjectable.release(isChangingConfigurations());
    }
}
