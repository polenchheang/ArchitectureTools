package dg2.dmi.com.dagger2.product.productList;

import android.support.annotation.NonNull;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 6/5/16.
 */

public interface View {
    void showResult(@NonNull List<Product> products);
    void showError(@NonNull Exception e);
    void registerEventListener(@NonNull ViewEventListener eventListener);
    void releaseEventListener();
}
