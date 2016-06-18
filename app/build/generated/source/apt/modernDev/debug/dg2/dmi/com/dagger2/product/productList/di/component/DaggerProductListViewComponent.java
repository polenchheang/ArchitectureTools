package dg2.dmi.com.dagger2.product.productList.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import dg2.dmi.com.dagger2.product.productList.View;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListViewModule;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListViewModule_ProvideProductListViewFactory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerProductListViewComponent implements ProductListViewComponent {
  private Provider<Presenter> getPresenterProvider;

  private Provider<View> provideProductListViewProvider;

  private DaggerProductListViewComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getPresenterProvider =
        new Factory<Presenter>() {
          private final ProductListComponent productListComponent = builder.productListComponent;

          @Override
          public Presenter get() {
            return Preconditions.checkNotNull(
                productListComponent.getPresenter(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideProductListViewProvider =
        DoubleCheck.provider(
            ProductListViewModule_ProvideProductListViewFactory.create(
                builder.productListViewModule, getPresenterProvider));
  }

  @Override
  public View provideView() {
    return provideProductListViewProvider.get();
  }

  public static final class Builder {
    private ProductListViewModule productListViewModule;

    private ProductListComponent productListComponent;

    private Builder() {}

    public ProductListViewComponent build() {
      if (productListViewModule == null) {
        throw new IllegalStateException(
            ProductListViewModule.class.getCanonicalName() + " must be set");
      }
      if (productListComponent == null) {
        throw new IllegalStateException(
            ProductListComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerProductListViewComponent(this);
    }

    public Builder productListViewModule(ProductListViewModule productListViewModule) {
      this.productListViewModule = Preconditions.checkNotNull(productListViewModule);
      return this;
    }

    public Builder productListComponent(ProductListComponent productListComponent) {
      this.productListComponent = Preconditions.checkNotNull(productListComponent);
      return this;
    }
  }
}
