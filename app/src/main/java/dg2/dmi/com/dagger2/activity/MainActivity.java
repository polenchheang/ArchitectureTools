package dg2.dmi.com.dagger2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dg2.dmi.com.dagger2.Dagger2App;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.dagger.DaggerProductListComponent;
import dg2.dmi.com.dagger2.dagger.ProductListComponent;
import dg2.dmi.com.dagger2.dagger.ProductListModule;
import dg2.dmi.com.dagger2.product.ProductListView;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.fab)
    void onRefresh() {
        mPresenter.getProduct();
    }

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    private static ProductListComponent sProductListComponent;

    @Inject
    ProductListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (sProductListComponent == null) {
            sProductListComponent = DaggerProductListComponent.builder()
                    .gitHubComponent(
                            ((Dagger2App)getApplication()).getGitHubComponent()
                    )
                    .productListModule(
                            new ProductListModule()
                    )
                    .build();
        }


        sProductListComponent.inject(this);

        mPresenter.bind(
                new ProductListView(mRecyclerView)
        );

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mPresenter.getLastProducts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unBind();
        if (!isChangingConfigurations()) {
            sProductListComponent = null;
        }
    }
}
