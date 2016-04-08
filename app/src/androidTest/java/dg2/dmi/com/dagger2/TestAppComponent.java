package dg2.dmi.com.dagger2;

import dagger.Component;

/**
 * Created by gguser on 2/8/16.
 */
@AppScope
@Component(modules = TestAppModule.class)
public interface TestAppComponent extends AppComponent {

    void inject(MainActivityTest activity);
}
