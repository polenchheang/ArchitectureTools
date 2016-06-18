package dg2.dmi.com.dagger2.product.productList.implement;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.ModelEventListener;
import dg2.dmi.com.dagger2.product.productList.View;

/**
 * Created by polenchheang on 6/15/16.
 */

class ModelEventListenerImpl implements ModelEventListener {

    private View mView;

    ModelEventListenerImpl(View view) {
        mView = view;
    }

    @Override
    public void onStart() {
        mView.showLoading();
    }

    @Override
    public void onError(@NonNull Exception e) {
        mView.showError(e);
    }

    @Override
    public void onResult(@NonNull List<Product> products) {
        mView.showResult(products);
    }

    @Override
    public void releaseResource() {
        mView = null;
    }

}
