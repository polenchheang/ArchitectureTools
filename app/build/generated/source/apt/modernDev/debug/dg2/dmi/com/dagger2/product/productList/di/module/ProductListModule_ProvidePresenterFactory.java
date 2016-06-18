package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListModule_ProvidePresenterFactory implements Factory<Presenter> {
  private final ProductListModule module;

  private final Provider<Model> modelProvider;

  public ProductListModule_ProvidePresenterFactory(
      ProductListModule module, Provider<Model> modelProvider) {
    assert module != null;
    this.module = module;
    assert modelProvider != null;
    this.modelProvider = modelProvider;
  }

  @Override
  public Presenter get() {
    return Preconditions.checkNotNull(
        module.providePresenter(modelProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Presenter> create(ProductListModule module, Provider<Model> modelProvider) {
    return new ProductListModule_ProvidePresenterFactory(module, modelProvider);
  }
}
