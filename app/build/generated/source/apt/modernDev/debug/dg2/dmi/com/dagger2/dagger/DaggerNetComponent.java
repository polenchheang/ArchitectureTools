package dg2.dmi.com.dagger2.dagger;

import android.app.Application;
import com.google.gson.Gson;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerNetComponent implements NetComponent {
  private Provider<Gson> provideGsonProvider;

  private Provider<Application> provideApplicationProvider;

  private Provider<Cache> provideOkHttpCacheProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private DaggerNetComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideGsonProvider = NetModule_ProvideGsonFactory.create(builder.netModule);

    this.provideApplicationProvider = AppModule_ProvideApplicationFactory.create(builder.appModule);

    this.provideOkHttpCacheProvider =
        NetModule_ProvideOkHttpCacheFactory.create(builder.netModule, provideApplicationProvider);

    this.provideOkHttpClientProvider =
        NetModule_ProvideOkHttpClientFactory.create(builder.netModule, provideOkHttpCacheProvider);

    this.provideRetrofitProvider =
        NetModule_ProvideRetrofitFactory.create(
            builder.netModule, provideGsonProvider, provideOkHttpClientProvider);
  }

  @Override
  public Retrofit retrofit() {
    return provideRetrofitProvider.get();
  }

  @Override
  public OkHttpClient okHttpClient() {
    return provideOkHttpClientProvider.get();
  }

  public static final class Builder {
    private NetModule netModule;

    private AppModule appModule;

    private Builder() {}

    public NetComponent build() {
      if (netModule == null) {
        throw new IllegalStateException(NetModule.class.getCanonicalName() + " must be set");
      }
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerNetComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder netModule(NetModule netModule) {
      this.netModule = Preconditions.checkNotNull(netModule);
      return this;
    }
  }
}
