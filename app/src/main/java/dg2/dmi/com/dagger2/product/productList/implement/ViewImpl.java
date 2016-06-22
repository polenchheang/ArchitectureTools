package dg2.dmi.com.dagger2.product.productList.implement;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.productList.factory.ProductFactory;
import dg2.dmi.com.dagger2.product.productList.adapter.ProductListAdapter;
import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.inteface.View;
import dg2.dmi.com.dagger2.product.productList.inteface.ViewEventListener;

/**
 * Created by polenchheang on 6/5/16.
 */

public class ViewImpl implements View {

    @Inject
    public ViewEventListener mNullEventListener;

    private List<Product> mEmptyList = Collections.emptyList();

    @BindView(R.id.my_recycler_view)
    RecyclerView mList;
    @BindView(android.R.id.empty)
    TextView mEmptyView;
    @BindView(R.id.refresh)
    android.view.View mRefreshView;

    private final ProductListAdapter mAdapter;
    private ViewEventListener mEventListener;

    @OnClick(R.id.refresh)
    void onRefresh() {
        mEventListener.onRefresh();
    }

    public ViewImpl(@NonNull ViewGroup root) {
        ButterKnife.bind(this,root);
        mAdapter = new ProductListAdapter(mEmptyList);
        mList.setAdapter(mAdapter);
        ProductFactory.getNullObjectComponent().inject(this);
    }

    @Override
    public void showResult(@NonNull List<Product> products) {
        mAdapter.setProducts(products);
    }

    @Override
    public void showError(@NonNull Exception e) {
        mEmptyView.setText(R.string.error_message);
        mAdapter.setProducts(mEmptyList);
    }

    @Override
    public void registerEventListener(@NonNull ViewEventListener eventListener) {
        mEventListener = eventListener;
    }

    @Override
    public void releaseEventListener() {
        mEventListener.releaseResource();
        mEventListener = mNullEventListener;
    }

    @Override
    public void showLoading() {
        mEmptyView.setText("Loading...");
    }

}
