package dg2.dmi.com.dagger2.product.productList;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.interfaces.ProductListApi;
import rx.Subscriber;

/**
 * Created by polenchheang on 6/5/16.
 */

public class ModelImpl implements Model {
    private ModelEventListener mNullEventListener = new ModelEventListener() {
        @Override
        public void onStart() {

        }

        @Override
        public void onError(Exception e) {

        }

        @Override
        public void onResult(List<Product> products) {

        }
    };
    private ProductListApi mProductListApi;
    private ModelEventListener mEventListener = mNullEventListener;
    private List<Product> mCachedResult = Collections.emptyList();

    @Inject
    public ModelImpl(@NonNull ProductListApi productListApi) {
        mProductListApi = productListApi;
    }

    @Override
    public void getLast() {
        if (mCachedResult.isEmpty()) {
            get();
        } else {
            mEventListener.onResult(mCachedResult);
        }
    }

    @Override
    public void get() {
        mEventListener.onStart();
        mProductListApi.getProductList()
                .subscribe(new Subscriber<List<Product>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mEventListener.onError((Exception) e);
                    }

                    @Override
                    public void onNext(List<Product> products) {
                        mEventListener.onResult(products);
                        mCachedResult = products;
                    }
                });
    }

    @Override
    public void registerEventListener(ModelEventListener eventListener) {
        mEventListener = eventListener;
        getLast();
    }

    @Override
    public void releaseEventListener() {
        mEventListener = mNullEventListener;
    }
}
