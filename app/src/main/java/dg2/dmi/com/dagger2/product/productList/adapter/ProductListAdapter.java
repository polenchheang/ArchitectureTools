package dg2.dmi.com.dagger2.product.productList.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.viewHolder.ViewHolder;
import dg2.dmi.com.dagger2.product.productList.viewHolder.ViewHolderFactory;

/**
 * Created by polenchheang on 5/17/16.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final ViewHolderFactory mViewHolderFactory;
    private List<Product> mProducts;

    public ProductListAdapter(@NonNull List<Product> products) {
        mProducts = products;
        mViewHolderFactory = new ViewHolderFactory();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mViewHolderFactory.create(parent,viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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
