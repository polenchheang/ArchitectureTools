package dg2.dmi.com.dagger2.product.productList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.adapter.ProductAdapter;
import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 6/5/16.
 */

public class ViewImpl implements View {

    private ViewEventListener mNullEventListener = new ViewEventListener() {
        @Override
        public void onRefresh() {

        }

        @Override
        public void onItemSelected(int index, Product product) {

        }
    };

    private List<Product> mEmptyList = Collections.emptyList();

    @BindView(R.id.my_recycler_view)
    RecyclerView mList;
    @BindView(android.R.id.empty)
    TextView mEmptyView;

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
    }

    @Override
    public void showResult(@NonNull List<Product> products) {
        mAdapter.setProducts(products);
        if (products.isEmpty()) {
            mEmptyView.setText(R.string.product_list_empty);
        }
    }

    @Override
    public void showError(@NonNull Exception e) {
        mAdapter.setProducts(mEmptyList);
        mEmptyView.setText("Error");
    }

    @Override
    public void registerEventListener(@NonNull ViewEventListener eventListener) {
        mEventListener = eventListener;
    }

    @Override
    public void releaseEventListener() {
        mEventListener = mNullEventListener;
    }
}
