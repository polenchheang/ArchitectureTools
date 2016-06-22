package dg2.dmi.com.dagger2.product.productList.di.module;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.product.domain.Product;
import dg2.dmi.com.dagger2.product.productList.inteface.Model;
import dg2.dmi.com.dagger2.product.productList.inteface.ModelEventListener;
import dg2.dmi.com.dagger2.product.productList.inteface.View;
import dg2.dmi.com.dagger2.product.productList.inteface.ViewEventListener;

/**
 * Created by gguser on 6/10/16.
 */
@Module
public class ProductListNullObjectModule {

    @Provides
    public View provideNullView() {
        return new View() {
            @Override
            public void showResult(@NonNull List<Product> products) {
                Log.d("NullObject","showResult");
            }

            @Override
            public void showError(@NonNull Exception e) {
                Log.d("NullObject","showError");
            }

            @Override
            public void registerEventListener(@NonNull ViewEventListener eventListener) {
                Log.d("NullObject","registerViewEvent");
            }

            @Override
            public void releaseEventListener() {
                Log.d("NullObject","releaseViewEvent");
            }

            @Override
            public void showLoading() {
                Log.d("NullObject","showLoading");
            }

        };
    }

    @Provides
    public Model provideNullModel() {
        return new Model() {
            @Override
            public void getLast() {
                Log.d("NullObject","getLast");
            }

            @Override
            public void get() {
                Log.d("NullObject","get");
            }

            @Override
            public void registerEventListener(@NonNull ModelEventListener eventListener) {
                Log.d("NullObject","registerModelEvent");
            }

            @Override
            public void releaseEventListener() {
                Log.d("NullObject","releaseModelEvent");
            }
        };
    }

    @Provides
    public ModelEventListener provideNullModelEventListener() {
        return new ModelEventListener() {
            @Override
            public void onStart() {
                Log.d("NullObject","start");
            }

            @Override
            public void onError(@NonNull Exception e) {
                Log.d("NullObject","onError");
            }

            @Override
            public void onResult(@NonNull List<Product> products) {
                Log.d("NullObject","onResult");
            }

            @Override
            public void releaseResource() {
                Log.d("NullObject","releaseModelResource");
            }

        };
    }

    @Provides
    public ViewEventListener provideNullViewEventListener() {
        return new ViewEventListener() {
            @Override
            public void onRefresh() {
                Log.d("NullObject","onRefresh");
            }

            @Override
            public void onItemSelected(int index,@NonNull Product product) {
                Log.d("NullObject","onItemSelected");
            }

            @Override
            public void releaseResource() {
                Log.d("NullObject","releaseViewResource");
            }
        };
    }
}
