package dg2.dmi.com.dagger2.product.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import dg2.dmi.com.dagger2.activity.MainActivity;
import dg2.dmi.com.dagger2.dagger.GitHubModule;
import dg2.dmi.com.dagger2.product.dagger.DaggerProductListViewComponent;
import dg2.dmi.com.dagger2.product.dagger.ProductListViewComponent;
import dg2.dmi.com.dagger2.product.dagger.ProductListViewModule;
import dg2.dmi.com.dagger2.product.domain.Product;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by polenchheang on 5/29/16.
 */

public final class ProductListPresenter {

    private GitHubModule.GitHubInterface mGitHubInterface;
    private List<Product> mLastProducts;

    private NullCallBack mNullCallBack = new NullCallBack();

    private ProductListViewComponent mProductListViewComponent;

    @Inject
    Callback mCallback = mNullCallBack;

    public ProductListPresenter(@NonNull GitHubModule.GitHubInterface gitHubInterface) {
        mGitHubInterface = gitHubInterface;
    }

    public void getProduct() {
        mGitHubInterface.getProductList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Product>>() {
                    @Override
                    public void onCompleted() {
                        mCallback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mCallback.onError(e);
                    }

                    @Override
                    public void onNext(List<Product> products) {
                        mCallback.onNext(products);
                        mLastProducts = products;
                    }
                });
    }

    public void bind(@NonNull MainActivity activity) {
        mProductListViewComponent = DaggerProductListViewComponent.builder()
                .productListViewModule(
                        new ProductListViewModule(activity)
                )
                .build();
        mProductListViewComponent.inject(this);
    }

    public void unBind() {
        mProductListViewComponent = null;
        mCallback = mNullCallBack;
    }

    public void onCreate() {
        if (mLastProducts == null) {
            getProduct();
        } else {
            mCallback.onNext(mLastProducts);
        }
    }

    public interface Callback {
        void onCompleted();
        void onError(Throwable e);
        void onNext(List<Product> products);
    }

    private class NullCallBack implements Callback {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(List<Product> products) {

        }
    }
}
