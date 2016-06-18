package dg2.dmi.com.dagger2.product.productList.implement;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import dg2.dmi.com.dagger2.product.ProductFactory;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.View;

/**
 * Created by polenchheang on 6/5/16.
 */

public class PresenterImpl implements Presenter {

    @Inject
    public View mNullView;

    @Inject
    public Model mNullModel;

    private View mView;
    private Model mModel;

    public PresenterImpl() {
        ProductFactory.getNullObjectComponent().inject(this);
        mView = mNullView;
        mModel = mNullModel;
    }

    @Override
    public void bind(@NonNull View view) {
        mView = view;
        something();
    }

    @Override
    public void bind(@NonNull Model model) {
        mModel = model;
        something();
    }

    private void something() {
        mModel.registerEventListener(new ModelEventListenerImpl(mView));
        mView.registerEventListener(new ViewEventListenerImpl(mModel));
    }

    @Override
    public void releaseView() {
        mView.releaseEventListener();
        mModel.releaseEventListener();
        mView = mNullView;
    }

    @Override
    public void releaseModel() {
        mView.releaseEventListener();
        mModel.releaseEventListener();
        mModel = mNullModel;
    }

}
