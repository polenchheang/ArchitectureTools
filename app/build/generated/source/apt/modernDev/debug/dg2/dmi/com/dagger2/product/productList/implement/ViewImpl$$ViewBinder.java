// Generated code from Butter Knife. Do not modify!
package dg2.dmi.com.dagger2.product.productList.implement;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ViewImpl$$ViewBinder<T extends ViewImpl> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131492975, "field 'mList'");
    target.mList = finder.castView(view, 2131492975, "field 'mList'");
    view = finder.findRequiredView(source, 16908292, "field 'mEmptyView'");
    target.mEmptyView = finder.castView(view, 16908292, "field 'mEmptyView'");
    view = finder.findRequiredView(source, 2131492976, "field 'mRefreshView' and method 'onRefresh'");
    target.mRefreshView = view;
    unbinder.view2131492976 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRefresh();
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ViewImpl> implements Unbinder {
    private T target;

    View view2131492976;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.mList = null;
      target.mEmptyView = null;
      view2131492976.setOnClickListener(null);
      target.mRefreshView = null;
    }
  }
}
