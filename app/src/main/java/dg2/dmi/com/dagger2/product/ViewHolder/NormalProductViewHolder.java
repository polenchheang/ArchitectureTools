package dg2.dmi.com.dagger2.product.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.domain.Product;

/**
 * Created by polenchheang on 5/18/16.
 */
public class NormalProductViewHolder extends ProductViewHolder {

    public static NormalProductViewHolder newInstance(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.normal_product_view, parent, false);
        return new NormalProductViewHolder(view);
    }

    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.description)
    TextView mDescription;

    public NormalProductViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(Product product) {
        mTitle.setText(product.getTitle());
        mDescription.setText(product.getDescription());
    }

}
