// Generated code from Butter Knife. Do not modify!
package dg2.dmi.com.dagger2.product.viewHolder;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class NormalProductViewHolder$$ViewBinder<T extends NormalProductViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131492933, "field 'mTitle'");
    target.mTitle = finder.castView(view, 2131492933, "field 'mTitle'");
    view = finder.findRequiredView(source, 2131492986, "field 'mDescription'");
    target.mDescription = finder.castView(view, 2131492986, "field 'mDescription'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends NormalProductViewHolder> implements Unbinder {
    private T target;

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
      target.mTitle = null;
      target.mDescription = null;
    }
  }
}
