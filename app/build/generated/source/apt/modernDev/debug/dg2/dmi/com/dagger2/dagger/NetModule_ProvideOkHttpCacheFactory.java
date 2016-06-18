package dg2.dmi.com.dagger2.dagger;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideOkHttpCacheFactory implements Factory<Cache> {
  private final NetModule module;

  private final Provider<Application> applicationProvider;

  public NetModule_ProvideOkHttpCacheFactory(
      NetModule module, Provider<Application> applicationProvider) {
    assert module != null;
    this.module = module;
    assert applicationProvider != null;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Cache get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpCache(applicationProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Cache> create(NetModule module, Provider<Application> applicationProvider) {
    return new NetModule_ProvideOkHttpCacheFactory(module, applicationProvider);
  }
}
