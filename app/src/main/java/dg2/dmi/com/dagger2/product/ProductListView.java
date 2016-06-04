package dg2.dmi.com.dagger2.product;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.adapter.ProductAdapter;
import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.interfaces.ProductListCallback;

/**
 * Created by polenchheang on 5/29/16.
 */

public class ProductListView implements ProductListCallback {
    private final Context mContext;

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    public ProductListView(ViewGroup rootView) {
        ButterKnife.bind(this,rootView);
        mContext = mRecyclerView.getContext();
        prepareList();
    }

    private void prepareList() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onCompleted() {
        Toast.makeText(mContext,"It's completed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(Throwable e) {
        List<Product> emptyProducts = Collections.emptyList();
        show(emptyProducts);
        Toast.makeText(mContext,"It's error "+e.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNext(List<Product> products) {
        show(products);
        Toast.makeText(mContext,"It's next on "+ products.size(),Toast.LENGTH_LONG).show();
    }

    private void show(@NonNull List<Product> product) {
        RecyclerView.Adapter<?> adapter = mRecyclerView.getAdapter();
        if (adapter == null) {
            ProductAdapter productAdapter = new ProductAdapter(product);
            mRecyclerView.setAdapter(productAdapter);
        } else {
            ProductAdapter productAdapter = (ProductAdapter) adapter;
            productAdapter.setProducts(product);
        }
    }
}
