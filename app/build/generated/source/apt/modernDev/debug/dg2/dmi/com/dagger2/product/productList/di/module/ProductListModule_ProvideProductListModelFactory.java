package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.Api;
import dg2.dmi.com.dagger2.product.productList.Model;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListModule_ProvideProductListModelFactory implements Factory<Model> {
  private final ProductListModule module;

  private final Provider<Api> apiProvider;

  public ProductListModule_ProvideProductListModelFactory(
      ProductListModule module, Provider<Api> apiProvider) {
    assert module != null;
    this.module = module;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  @Override
  public Model get() {
    return Preconditions.checkNotNull(
        module.provideProductListModel(apiProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Model> create(ProductListModule module, Provider<Api> apiProvider) {
    return new ProductListModule_ProvideProductListModelFactory(module, apiProvider);
  }
}
