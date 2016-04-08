package dg2.dmi.com.dagger2;

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

    @Override
    public TestAppComponent getAppComponent() {
        return mTestAppComponent;
    }
}