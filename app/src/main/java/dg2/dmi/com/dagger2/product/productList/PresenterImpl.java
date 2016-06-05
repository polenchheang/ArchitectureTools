package dg2.dmi.com.dagger2.product.productList;

import android.support.annotation.NonNull;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 6/5/16.
 */

public class PresenterImpl implements Presenter {

    private View mNullView = new View() {
        @Override
        public void showResult(@NonNull List<Product> products) {

        }

        @Override
        public void showError(@NonNull Exception e) {

        }

        @Override
        public void registerEventListener(@NonNull ViewEventListener eventListener) {

        }

        @Override
        public void releaseEventListener() {

        }
    };

    private Model mNullModel = new Model() {
        @Override
        public void getLast() {

        }

        @Override
        public void get() {

        }

        @Override
        public void registerEventListener(@NonNull ModelEventListener eventListener) {

        }

        @Override
        public void releaseEventListener() {

        }
    };

    private View mView = mNullView;
    private Model mModel = mNullModel;

    public PresenterImpl() {
    }

    @Override
    public void bind(@NonNull View view) {
        mView = view;
        mView.registerEventListener(new ViewEventListenerImpl());
        mModel.getLast();
    }

    @Override
    public void bind(@NonNull Model model) {
        mModel = model;
        mModel.registerEventListener(new ModelEventListenerImpl());
    }

    @Override
    public void releaseView() {
        mView.releaseEventListener();
        mView = mNullView;
    }

    @Override
    public void releaseModel() {
        mModel.releaseEventListener();
        mModel = mNullModel;
    }

    private class ViewEventListenerImpl implements ViewEventListener {

        @Override
        public void onRefresh() {
            mModel.get();
        }

        @Override
        public void onItemSelected(int index, @NonNull Product product) {

        }
    }

    private class ModelEventListenerImpl implements ModelEventListener {

        @Override
        public void onStart() {
        }

        @Override
        public void onError(@NonNull Exception e) {
            mView.showError(e);
        }

        @Override
        public void onResult(@NonNull List<Product> products) {
            mView.showResult(products);
        }
    }
}
