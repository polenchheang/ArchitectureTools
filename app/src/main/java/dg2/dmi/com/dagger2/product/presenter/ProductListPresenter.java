package dg2.dmi.com.dagger2.product.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import dg2.dmi.com.dagger2.dagger.GitHubModule;
import dg2.dmi.com.dagger2.product.domain.Product;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by polenchheang on 5/29/16.
 */

public final class ProductListPresenter {

    private Callback mCallback;
    private GitHubModule.GitHubInterface mGitHubInterface;
    private List<Product> mLastProducts;

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

    public void bind(@NonNull Callback callback) {
        mCallback = callback;
    }

    public void unBind() {
        mCallback = null;
    }

    public void getLastProducts() {
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
}
