package dg2.dmi.com.dagger2.product.productList.inteface;

import android.support.annotation.NonNull;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 6/5/16.
 */

public interface ModelEventListener {
    void onStart();
    void onError(@NonNull Exception e);
    void onResult(@NonNull List<Product> products);
    void releaseResource();
}
