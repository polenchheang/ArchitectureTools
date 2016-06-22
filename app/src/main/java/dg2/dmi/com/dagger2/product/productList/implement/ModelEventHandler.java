package dg2.dmi.com.dagger2.product.productList.implement;

import android.support.annotation.NonNull;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.inteface.ModelEventListener;
import dg2.dmi.com.dagger2.product.productList.inteface.View;

/**
 * Created by polenchheang on 6/15/16.
 */

class ModelEventHandler implements ModelEventListener {

    private View mView;

    ModelEventHandler(View view) {
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
