package dg2.dmi.com.dagger2.product.productList.implement;

import dagger.MembersInjector;
import dg2.dmi.com.dagger2.product.productList.ModelEventListener;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ModelImpl_MembersInjector implements MembersInjector<ModelImpl> {
  private final Provider<ModelEventListener> mNullEventListenerProvider;

  public ModelImpl_MembersInjector(Provider<ModelEventListener> mNullEventListenerProvider) {
    assert mNullEventListenerProvider != null;
    this.mNullEventListenerProvider = mNullEventListenerProvider;
  }

  public static MembersInjector<ModelImpl> create(
      Provider<ModelEventListener> mNullEventListenerProvider) {
    return new ModelImpl_MembersInjector(mNullEventListenerProvider);
  }

  @Override
  public void injectMembers(ModelImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mNullEventListener = mNullEventListenerProvider.get();
  }
}
