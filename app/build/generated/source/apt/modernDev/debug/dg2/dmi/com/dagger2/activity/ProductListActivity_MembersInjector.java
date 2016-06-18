package dg2.dmi.com.dagger2.activity;

import dagger.MembersInjector;
import dg2.dmi.com.dagger2.product.productList.Presenter;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProductListActivity_MembersInjector
    implements MembersInjector<ProductListActivity> {
  private final Provider<Presenter> mPresenterProvider;

  public ProductListActivity_MembersInjector(Provider<Presenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ProductListActivity> create(
      Provider<Presenter> mPresenterProvider) {
    return new ProductListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ProductListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      ProductListActivity instance, Provider<Presenter> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
