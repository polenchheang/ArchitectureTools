package dg2.dmi.com.dagger2.product.productList.implement;

import android.support.annotation.NonNull;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.ViewEventListener;

/**
 * Created by polenchheang on 6/15/16.
 */

class ViewEventListenerImpl implements ViewEventListener {

    private Model mModel;

    ViewEventListenerImpl(Model model) {
        mModel = model;
    }

    @Override
    public void onRefresh() {
        mModel.get();
    }

    @Override
    public void onItemSelected(int index, @NonNull Product product) {

    }

    @Override
    public void releaseResource() {
        mModel = null;
    }
}
