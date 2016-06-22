package dg2.dmi.com.dagger2.product.productList.viewHolder;

import android.view.ViewGroup;

/**
 * Created by polenchheang on 5/18/16.
 */
public class ViewHolderFactory {
    public ViewHolder create(ViewGroup parent, int viewType) {
        switch (viewType) {
            default:
                return NormalViewHolder.newInstance(parent);
        }
    }
}
