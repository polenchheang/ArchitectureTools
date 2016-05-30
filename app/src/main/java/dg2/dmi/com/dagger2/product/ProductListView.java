package dg2.dmi.com.dagger2.product;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import dg2.dmi.com.dagger2.product.adapter.ProductAdapter;
import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.presenter.ProductListPresenter;

/**
 * Created by polenchheang on 5/29/16.
 */

public class ProductListView implements ProductListPresenter.Callback {
    private final Context mContext;
    private RecyclerView mRecyclerView;

    public ProductListView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
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
        Toast.makeText(mContext,"It's error "+e.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNext(List<Product> products) {
        show(products);
        Toast.makeText(mContext,"It's next on "+ products.size(),Toast.LENGTH_LONG).show();
    }

    private void show(@NonNull List<Product> product) {
        ProductAdapter productAdapter = new ProductAdapter(product);
        mRecyclerView.setAdapter(productAdapter);
    }
}
