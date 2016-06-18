package dg2.dmi.com.dagger2.product.productList.implement;

import dagger.MembersInjector;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.View;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PresenterImpl_MembersInjector implements MembersInjector<PresenterImpl> {
  private final Provider<View> mNullViewProvider;

  private final Provider<Model> mNullModelProvider;

  public PresenterImpl_MembersInjector(
      Provider<View> mNullViewProvider, Provider<Model> mNullModelProvider) {
    assert mNullViewProvider != null;
    this.mNullViewProvider = mNullViewProvider;
    assert mNullModelProvider != null;
    this.mNullModelProvider = mNullModelProvider;
  }

  public static MembersInjector<PresenterImpl> create(
      Provider<View> mNullViewProvider, Provider<Model> mNullModelProvider) {
    return new PresenterImpl_MembersInjector(mNullViewProvider, mNullModelProvider);
  }

  @Override
  public void injectMembers(PresenterImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mNullView = mNullViewProvider.get();
    instance.mNullModel = mNullModelProvider.get();
  }
}
