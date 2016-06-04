package dg2.dmi.com.dagger2.product.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.viewHolder.ProductViewHolder;
import dg2.dmi.com.dagger2.product.viewHolder.ViewHolderFactory;

/**
 * Created by polenchheang on 5/17/16.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private final ViewHolderFactory mViewHolderFactory;
    private List<Product> mProducts;

    public ProductAdapter(@NonNull List<Product> products) {
        mProducts = products;
        mViewHolderFactory = new ViewHolderFactory();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mViewHolderFactory.create(parent,viewType);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = mProducts.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return mProducts.isEmpty()? 0 : mProducts.size();
    }


    public List<Product> geItems() {
        return mProducts;
    }

    public void setProducts(List<Product> products) {
        this.mProducts = products;
        notifyDataSetChanged();
    }
}
