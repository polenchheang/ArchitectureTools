package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.ModelEventListener;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListNullObjectModule_ProvideNullModelEventListenerFactory
    implements Factory<ModelEventListener> {
  private final ProductListNullObjectModule module;

  public ProductListNullObjectModule_ProvideNullModelEventListenerFactory(
      ProductListNullObjectModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public ModelEventListener get() {
    return Preconditions.checkNotNull(
        module.provideNullModelEventListener(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ModelEventListener> create(ProductListNullObjectModule module) {
    return new ProductListNullObjectModule_ProvideNullModelEventListenerFactory(module);
  }
}
