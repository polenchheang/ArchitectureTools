package dg2.dmi.com.dagger2;

import android.support.annotation.NonNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.Api;
import dg2.dmi.com.dagger2.product.productList.ModelEventListener;
import dg2.dmi.com.dagger2.product.productList.implement.ModelImpl;
import rx.Observable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ProductListModelUnitTest {

    private List<Product> mProducts;
    private ModelImpl mModel;
    private MyModelEventListener mEventListener;

    @Before
    public void setUp() throws Exception {
        mProducts = new ArrayList<>(1);
        mProducts.add(new Product());
        mModel = new ModelImpl(new Api() {
            @Override
            public Observable<List<Product>> getProductList() {
                return Observable.just(mProducts);
            }
        });
        mEventListener = new MyModelEventListener();
    }

    @Test
    public void getAfterRegisterEventListener() throws Exception {
        mModel.registerEventListener(mEventListener);
        assertEquals(mProducts, mEventListener.getLastResult());
        assertTrue(mEventListener.isStarted());
    }

    @Test
    public void lastProductCached() throws Exception {
        mModel.registerEventListener(mEventListener);
        mEventListener.resetIsStarted();
        mModel.getLast();
        assertEquals(mProducts, mEventListener.getLastResult());
        assertFalse(mEventListener.isStarted());
    }

    @After
    public void tearDown() throws Exception {
        mModel.releaseEventListener();
        mModel = null;
        mEventListener = null;
        mProducts = null;
    }

    private class MyModelEventListener implements ModelEventListener {

        private List<Product> mProducts;
        private boolean mIsStarted;
        @Override
        public void onStart() {
            mIsStarted = true;
        }

        @Override
        public void onError(@NonNull Exception e) {

        }

        @Override
        public void onResult(@NonNull List<Product> products) {
            mProducts = products;
        }

        @Override
        public void releaseResource() {

        }

        List<Product> getLastResult() {
            return mProducts;
        }

        boolean isStarted() {
            return mIsStarted;
        }

        void resetIsStarted() {
            mIsStarted = false;
        }
    };
}