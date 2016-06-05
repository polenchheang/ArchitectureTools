package dg2.dmi.com.dagger2.product.productList;

import android.support.annotation.NonNull;

/**
 * Created by polenchheang on 6/5/16.
 */

public interface Model {
    void getLast();
    void get();
    void registerEventListener(@NonNull ModelEventListener eventListener);
    void releaseEventListener();
}
