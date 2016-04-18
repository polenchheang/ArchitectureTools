package dg2.dmi.com.dagger2;

import dg2.dmi.com.dagger2.dagger.DaggerTestAppComponent;
import dg2.dmi.com.dagger2.dagger.TestAppComponent;
import dg2.dmi.com.dagger2.dagger.TestAppModule;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends Dagger2App {
    private TestAppComponent mTestAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mTestAppComponent = DaggerTestAppComponent.builder()
                .testAppModule(new TestAppModule(this))
                .build();
    }

    public TestAppComponent getAppComponent() {
        return mTestAppComponent;
    }
}