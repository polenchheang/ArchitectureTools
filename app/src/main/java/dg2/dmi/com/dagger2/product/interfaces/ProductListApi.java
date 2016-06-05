package dg2.dmi.com.dagger2.product.interfaces;

import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by polenchheang on 6/5/16.
 */
public interface ProductListApi {
    @GET("/products")
    Observable<List<Product>> getProductList();
}
