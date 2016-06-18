package dg2.dmi.com.dagger2.widgets;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by polenchheang on 6/4/16.
 */

public class ProductListView extends RecyclerView {
    private View mEmptyView;

    public ProductListView(Context context) {
        this(context,null);
    }

    public ProductListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ProductListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(VERTICAL);
        setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            mEmptyView = ((Activity) getContext()).findViewById(android.R.id.empty);
            checkEmpty();
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);

        if (adapter != null) {
            adapter.registerAdapterDataObserver(mAdapterDataObserver);
        }
        mAdapterDataObserver.onChanged();
    }

    AdapterDataObserver mAdapterDataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            if (mEmptyView != null) {
                checkEmpty();
            }
        }

    };

    private void checkEmpty() {
        Adapter<?> adapter = getAdapter();
        if (adapter != null && adapter.getItemCount() == 0) {
            mEmptyView.setVisibility(VISIBLE);
            setVisibility(GONE);
        } else {
            mEmptyView.setVisibility(GONE);
            setVisibility(VISIBLE);
        }
    }
}
