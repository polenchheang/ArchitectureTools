package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.Api;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListModule_ProvideProductListApiFactory implements Factory<Api> {
  private final ProductListModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ProductListModule_ProvideProductListApiFactory(
      ProductListModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public Api get() {
    return Preconditions.checkNotNull(
        module.provideProductListApi(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Api> create(ProductListModule module, Provider<Retrofit> retrofitProvider) {
    return new ProductListModule_ProvideProductListApiFactory(module, retrofitProvider);
  }
}
