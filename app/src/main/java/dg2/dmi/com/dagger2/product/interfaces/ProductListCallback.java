package dg2.dmi.com.dagger2.product.interfaces;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 6/4/16.
 */
public interface ProductListCallback {
    void onCompleted();
    void onError(Throwable e);
    void onNext(List<Product> products);
}
