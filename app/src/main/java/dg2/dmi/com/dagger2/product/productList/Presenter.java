package dg2.dmi.com.dagger2.product.productList;

import android.support.annotation.NonNull;

/**
 * Created by polenchheang on 6/5/16.
 */

public interface Presenter {
    void bind(@NonNull View view);
    void bind(@NonNull Model model);
    void releaseView();
    void releaseModel();
}
