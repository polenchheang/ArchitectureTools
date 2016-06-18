package dg2.dmi.com.dagger2.product.productList.di.component;

import android.app.Application;
import com.google.gson.Gson;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.activity.ProductListActivity;
import dg2.dmi.com.dagger2.activity.ProductListActivity_MembersInjector;
import dg2.dmi.com.dagger2.dagger.AppModule;
import dg2.dmi.com.dagger2.dagger.AppModule_ProvideApplicationFactory;
import dg2.dmi.com.dagger2.dagger.NetModule;
import dg2.dmi.com.dagger2.dagger.NetModule_ProvideGsonFactory;
import dg2.dmi.com.dagger2.dagger.NetModule_ProvideOkHttpCacheFactory;
import dg2.dmi.com.dagger2.dagger.NetModule_ProvideOkHttpClientFactory;
import dg2.dmi.com.dagger2.dagger.NetModule_ProvideRetrofitFactory;
import dg2.dmi.com.dagger2.product.productList.Api;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListModule;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListModule_ProvidePresenterFactory;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListModule_ProvideProductListApiFactory;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListModule_ProvideProductListModelFactory;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerProductListComponent implements ProductListComponent {
  private Provider<Gson> provideGsonProvider;

  private Provider<Application> provideApplicationProvider;

  private Provider<Cache> provideOkHttpCacheProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<Api> provideProductListApiProvider;

  private Provider<Model> provideProductListModelProvider;

  private Provider<Presenter> providePresenterProvider;

  private MembersInjector<ProductListActivity> productListActivityMembersInjector;

  private DaggerProductListComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideGsonProvider = NetModule_ProvideGsonFactory.create(builder.netModule);

    this.provideApplicationProvider = AppModule_ProvideApplicationFactory.create(builder.appModule);

    this.provideOkHttpCacheProvider =
        NetModule_ProvideOkHttpCacheFactory.create(builder.netModule, provideApplicationProvider);

    this.provideOkHttpClientProvider =
        NetModule_ProvideOkHttpClientFactory.create(builder.netModule, provideOkHttpCacheProvider);

    this.provideRetrofitProvider =
        NetModule_ProvideRetrofitFactory.create(
            builder.netModule, provideGsonProvider, provideOkHttpClientProvider);

    this.provideProductListApiProvider =
        DoubleCheck.provider(
            ProductListModule_ProvideProductListApiFactory.create(
                builder.productListModule, provideRetrofitProvider));

    this.provideProductListModelProvider =
        DoubleCheck.provider(
            ProductListModule_ProvideProductListModelFactory.create(
                builder.productListModule, provideProductListApiProvider));

    this.providePresenterProvider =
        DoubleCheck.provider(
            ProductListModule_ProvidePresenterFactory.create(
                builder.productListModule, provideProductListModelProvider));

    this.productListActivityMembersInjector =
        ProductListActivity_MembersInjector.create(providePresenterProvider);
  }

  @Override
  public void inject(ProductListActivity activity) {
    productListActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public Presenter getPresenter() {
    return providePresenterProvider.get();
  }

  public static final class Builder {
    private NetModule netModule;

    private AppModule appModule;

    private ProductListModule productListModule;

    private Builder() {}

    public ProductListComponent build() {
      if (netModule == null) {
        throw new IllegalStateException(NetModule.class.getCanonicalName() + " must be set");
      }
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (productListModule == null) {
        this.productListModule = new ProductListModule();
      }
      return new DaggerProductListComponent(this);
    }

    public Builder productListModule(ProductListModule productListModule) {
      this.productListModule = Preconditions.checkNotNull(productListModule);
      return this;
    }

    public Builder netModule(NetModule netModule) {
      this.netModule = Preconditions.checkNotNull(netModule);
      return this;
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }
}
