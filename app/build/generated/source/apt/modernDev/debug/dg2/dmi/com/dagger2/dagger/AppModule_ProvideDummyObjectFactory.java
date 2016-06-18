package dg2.dmi.com.dagger2.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.domain.DummyObject;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideDummyObjectFactory implements Factory<DummyObject> {
  private final AppModule module;

  public AppModule_ProvideDummyObjectFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public DummyObject get() {
    return Preconditions.checkNotNull(
        module.provideDummyObject(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DummyObject> create(AppModule module) {
    return new AppModule_ProvideDummyObjectFactory(module);
  }
}
