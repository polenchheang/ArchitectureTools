package dg2.dmi.com.dagger2.product.productList.inteface;

import android.support.annotation.NonNull;

import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 6/5/16.
 */

public interface ViewEventListener {
    void onRefresh();
    void onItemSelected(int index,@NonNull Product product);
    void releaseResource();
}
