package dg2.dmi.com.dagger2.product.ViewHolder;

import android.view.ViewGroup;

/**
 * Created by polenchheang on 5/18/16.
 */
public class ViewHolderFactory {
    public ProductViewHolder create(ViewGroup parent, int viewType) {
        switch (viewType) {
            default:
                return NormalProductViewHolder.newInstance(parent);
        }
    }
}
