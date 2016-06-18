package dg2.dmi.com.dagger2.product.productList.implement;

import dagger.MembersInjector;
import dg2.dmi.com.dagger2.product.productList.ViewEventListener;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ViewImpl_MembersInjector implements MembersInjector<ViewImpl> {
  private final Provider<ViewEventListener> mNullEventListenerProvider;

  public ViewImpl_MembersInjector(Provider<ViewEventListener> mNullEventListenerProvider) {
    assert mNullEventListenerProvider != null;
    this.mNullEventListenerProvider = mNullEventListenerProvider;
  }

  public static MembersInjector<ViewImpl> create(
      Provider<ViewEventListener> mNullEventListenerProvider) {
    return new ViewImpl_MembersInjector(mNullEventListenerProvider);
  }

  @Override
  public void injectMembers(ViewImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mNullEventListener = mNullEventListenerProvider.get();
  }
}
