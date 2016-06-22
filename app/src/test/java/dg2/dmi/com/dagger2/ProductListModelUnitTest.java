package dg2.dmi.com.dagger2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.inteface.Api;
import dg2.dmi.com.dagger2.product.productList.inteface.ModelEventListener;
import dg2.dmi.com.dagger2.product.productList.implement.ModelImpl;
import rx.Observable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ProductListModelUnitTest {

    private List<Product> mProducts;
    private ModelImpl mModel;
    private ModelEventListener mEventListener;

    public ProductListModelUnitTest() {
        mProducts = new ArrayList<>(1);
        mProducts.add(new Product());
    }

    @Before
    public void setUp() throws Exception {
        mModel = new ModelImpl(new Api() {
            @Override
            public Observable<List<Product>> getProductList() {
                return Observable.just(mProducts);
            }
        });
        mEventListener = mock(ModelEventListener.class);
    }

    @Test
    public void getAfterRegisterEventListener() throws Exception {
        mModel.registerEventListener(mEventListener);
        verify(mEventListener,times(1)).onResult(mProducts);
        verify(mEventListener,times(1)).onStart();
    }

    @Test
    public void lastProductCached() throws Exception {
        mModel.registerEventListener(mEventListener);
        mModel.getLast();
        verify(mEventListener,times(2)).onResult(mProducts);
        verify(mEventListener,times(1)).onStart();
    }

    @After
    public void tearDown() throws Exception {
        mModel.releaseEventListener();
        mModel = null;
        mEventListener = null;
        mProducts = null;
    }

}