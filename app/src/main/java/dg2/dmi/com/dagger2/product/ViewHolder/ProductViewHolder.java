package dg2.dmi.com.dagger2.product.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 5/18/16.
 */
public abstract class ProductViewHolder extends RecyclerView.ViewHolder {
    public ProductViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Product product);
}
