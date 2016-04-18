package dg2.dmi.com.dagger2.dagger;

import dagger.Component;
import dg2.dmi.com.dagger2.activity.MainActivityTest;
import dg2.dmi.com.dagger2.dagger.scope.AppScope;

/**
 * Created by gguser on 2/8/16.
 */
@AppScope
@Component(modules = TestAppModule.class)
public interface TestAppComponent {

    void inject(MainActivityTest activity);
}
