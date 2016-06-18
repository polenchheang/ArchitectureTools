package dg2.dmi.com.dagger2.product.productList.di.component;

import dagger.MembersInjector;
import dagger.internal.Preconditions;
import dg2.dmi.com.dagger2.product.productList.Model;
import dg2.dmi.com.dagger2.product.productList.ModelEventListener;
import dg2.dmi.com.dagger2.product.productList.View;
import dg2.dmi.com.dagger2.product.productList.ViewEventListener;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListNullObjectModule;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListNullObjectModule_ProvideNullModelEventListenerFactory;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListNullObjectModule_ProvideNullModelFactory;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListNullObjectModule_ProvideNullViewEventListenerFactory;
import dg2.dmi.com.dagger2.product.productList.di.module.ProductListNullObjectModule_ProvideNullViewFactory;
import dg2.dmi.com.dagger2.product.productList.implement.ModelImpl;
import dg2.dmi.com.dagger2.product.productList.implement.ModelImpl_MembersInjector;
import dg2.dmi.com.dagger2.product.productList.implement.PresenterImpl;
import dg2.dmi.com.dagger2.product.productList.implement.PresenterImpl_MembersInjector;
import dg2.dmi.com.dagger2.product.productList.implement.ViewImpl;
import dg2.dmi.com.dagger2.product.productList.implement.ViewImpl_MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerProductListNullObjectComponent implements ProductListNullObjectComponent {
  private Provider<View> provideNullViewProvider;

  private Provider<Model> provideNullModelProvider;

  private MembersInjector<PresenterImpl> presenterImplMembersInjector;

  private Provider<ViewEventListener> provideNullViewEventListenerProvider;

  private MembersInjector<ViewImpl> viewImplMembersInjector;

  private Provider<ModelEventListener> provideNullModelEventListenerProvider;

  private MembersInjector<ModelImpl> modelImplMembersInjector;

  private DaggerProductListNullObjectComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ProductListNullObjectComponent create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideNullViewProvider =
        ProductListNullObjectModule_ProvideNullViewFactory.create(
            builder.productListNullObjectModule);

    this.provideNullModelProvider =
        ProductListNullObjectModule_ProvideNullModelFactory.create(
            builder.productListNullObjectModule);

    this.presenterImplMembersInjector =
        PresenterImpl_MembersInjector.create(provideNullViewProvider, provideNullModelProvider);

    this.provideNullViewEventListenerProvider =
        ProductListNullObjectModule_ProvideNullViewEventListenerFactory.create(
            builder.productListNullObjectModule);

    this.viewImplMembersInjector =
        ViewImpl_MembersInjector.create(provideNullViewEventListenerProvider);

    this.provideNullModelEventListenerProvider =
        ProductListNullObjectModule_ProvideNullModelEventListenerFactory.create(
            builder.productListNullObjectModule);

    this.modelImplMembersInjector =
        ModelImpl_MembersInjector.create(provideNullModelEventListenerProvider);
  }

  @Override
  public void inject(PresenterImpl presenter) {
    presenterImplMembersInjector.injectMembers(presenter);
  }

  @Override
  public void inject(ViewImpl view) {
    viewImplMembersInjector.injectMembers(view);
  }

  @Override
  public void inject(ModelImpl model) {
    modelImplMembersInjector.injectMembers(model);
  }

  @Override
  public View getNullView() {
    return provideNullViewProvider.get();
  }

  @Override
  public Model getNullModel() {
    return provideNullModelProvider.get();
  }

  @Override
  public ModelEventListener getNullModelEventListener() {
    return provideNullModelEventListenerProvider.get();
  }

  @Override
  public ViewEventListener getNullViewEventListener() {
    return provideNullViewEventListenerProvider.get();
  }

  public static final class Builder {
    private ProductListNullObjectModule productListNullObjectModule;

    private Builder() {}

    public ProductListNullObjectComponent build() {
      if (productListNullObjectModule == null) {
        this.productListNullObjectModule = new ProductListNullObjectModule();
      }
      return new DaggerProductListNullObjectComponent(this);
    }

    public Builder productListNullObjectModule(
        ProductListNullObjectModule productListNullObjectModule) {
      this.productListNullObjectModule = Preconditions.checkNotNull(productListNullObjectModule);
      return this;
    }
  }
}
