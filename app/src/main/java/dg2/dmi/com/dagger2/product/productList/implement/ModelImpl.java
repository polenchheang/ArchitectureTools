package dg2.dmi.com.dagger2.product.productList.implement;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import dg2.dmi.com.dagger2.product.ProductFactory;
import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.Api;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.ModelEventListener;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by polenchheang on 6/5/16.
 */

public class ModelImpl implements Model {
    @Inject
    public ModelEventListener mNullEventListener;

    private Api mApi;
    private ModelEventListener mEventListener;
    private List<Product> mCachedResult = Collections.emptyList();
    private Subscriber<List<Product>> mSubscriber;
    private Observable<List<Product>> mObservable;

    public ModelImpl(@NonNull Api api) {
        mApi = api;
        ProductFactory.getNullObjectComponent().inject(this);
        mEventListener = mNullEventListener;
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
        Subscriber<List<Product>> subscriber = getSubscriber();
        getListObservable()
                .subscribe(subscriber);
    }

    @Override
    public void registerEventListener(@NonNull ModelEventListener eventListener) {
        mEventListener = eventListener;
        getLast();
    }

    @NonNull
    private Observable<List<Product>> getListObservable() {
        if (mObservable == null) {
            mObservable = mApi.getProductList();
        }

        return mObservable;
    }

    @NonNull
    private Subscriber<List<Product>> getSubscriber() {
        if (mSubscriber == null) {
            mSubscriber = new Subscriber<List<Product>>() {
                @Override
                public void onCompleted() {
                    unsubscribe();
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

                @Override
                public void onStart() {
                    mEventListener.onStart();
                }
            };
        }

        return mSubscriber;
    }

    @Override
    public void releaseEventListener() {
        mEventListener.releaseResource();
        mEventListener = mNullEventListener;
    }
}
