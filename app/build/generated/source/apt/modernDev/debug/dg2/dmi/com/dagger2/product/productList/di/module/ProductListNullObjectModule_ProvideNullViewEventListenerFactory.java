package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.ViewEventListener;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListNullObjectModule_ProvideNullViewEventListenerFactory
    implements Factory<ViewEventListener> {
  private final ProductListNullObjectModule module;

  public ProductListNullObjectModule_ProvideNullViewEventListenerFactory(
      ProductListNullObjectModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public ViewEventListener get() {
    return Preconditions.checkNotNull(
        module.provideNullViewEventListener(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ViewEventListener> create(ProductListNullObjectModule module) {
    return new ProductListNullObjectModule_ProvideNullViewEventListenerFactory(module);
  }
}
