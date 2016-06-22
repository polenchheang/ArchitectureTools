package dg2.dmi.com.dagger2.product.productList.implement;

import android.support.annotation.NonNull;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.inteface.Model;
import dg2.dmi.com.dagger2.product.productList.inteface.ViewEventListener;

/**
 * Created by polenchheang on 6/15/16.
 */

class ViewEventHandler implements ViewEventListener {

    private Model mModel;

    ViewEventHandler(Model model) {
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
