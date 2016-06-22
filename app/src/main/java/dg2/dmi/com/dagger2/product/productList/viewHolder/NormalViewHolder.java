package dg2.dmi.com.dagger2.product.productList.viewHolder;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.databinding.NormalProductViewBinding;
import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 5/18/16.
 */
public class NormalViewHolder extends ViewHolder {

    private NormalProductViewBinding mBinding;

    static NormalViewHolder newInstance(ViewGroup parent) {
        return new NormalViewHolder((NormalProductViewBinding) DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.normal_product_view,
                        parent,
                        false)
        );
    }

    private NormalViewHolder(NormalProductViewBinding itemView) {
        super(itemView.getRoot());
        mBinding = itemView;
    }

    @Override
    public void bind(Product product) {
        mBinding.setProduct(product);
    }

}
