package dg2.dmi.com.dagger2.product.productList.implement;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.Api;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by polenchheang on 6/18/16.
 */

// Decorate pattern, Decorate Api as Async task
public class ApiAsyncImpl implements Api {

    private final Api mApi;

    public ApiAsyncImpl(Retrofit retrofit) {
        mApi = retrofit.create(Api.class);
    }

    @Override
    public Observable<List<Product>> getProductList() {
        return mApi.getProductList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
