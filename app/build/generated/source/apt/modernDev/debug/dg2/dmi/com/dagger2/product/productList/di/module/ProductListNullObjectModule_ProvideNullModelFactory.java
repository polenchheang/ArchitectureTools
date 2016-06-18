package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.Model;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListNullObjectModule_ProvideNullModelFactory implements Factory<Model> {
  private final ProductListNullObjectModule module;

  public ProductListNullObjectModule_ProvideNullModelFactory(ProductListNullObjectModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Model get() {
    return Preconditions.checkNotNull(
        module.provideNullModel(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Model> create(ProductListNullObjectModule module) {
    return new ProductListNullObjectModule_ProvideNullModelFactory(module);
  }
}
