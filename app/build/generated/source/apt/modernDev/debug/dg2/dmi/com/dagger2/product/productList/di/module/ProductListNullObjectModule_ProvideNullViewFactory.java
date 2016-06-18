package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.View;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListNullObjectModule_ProvideNullViewFactory implements Factory<View> {
  private final ProductListNullObjectModule module;

  public ProductListNullObjectModule_ProvideNullViewFactory(ProductListNullObjectModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public View get() {
    return Preconditions.checkNotNull(
        module.provideNullView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<View> create(ProductListNullObjectModule module) {
    return new ProductListNullObjectModule_ProvideNullViewFactory(module);
  }
}
