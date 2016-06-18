package dg2.dmi.com.dagger2.product.productList.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.View;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListViewModule_ProvideProductListViewFactory implements Factory<View> {
  private final ProductListViewModule module;

  private final Provider<Presenter> presenterProvider;

  public ProductListViewModule_ProvideProductListViewFactory(
      ProductListViewModule module, Provider<Presenter> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public View get() {
    return Preconditions.checkNotNull(
        module.provideProductListView(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<View> create(
      ProductListViewModule module, Provider<Presenter> presenterProvider) {
    return new ProductListViewModule_ProvideProductListViewFactory(module, presenterProvider);
  }
}
