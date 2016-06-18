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
import dg2.dmi.com.dagger2.product.ProductFactory;
import dg2.dmi.com.dagger2.product.adapter.ProductAdapter;
import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.View;
import dg2.dmi.com.dagger2.product.productList.ViewEventListener;

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

    private final ProductAdapter mAdapter;
    private ViewEventListener mEventListener;

    @OnClick(R.id.refresh)
    void onRefresh() {
        mEventListener.onRefresh();
    }

    public ViewImpl(@NonNull ViewGroup root) {
        ButterKnife.bind(this,root);
        mAdapter = new ProductAdapter(mEmptyList);
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
