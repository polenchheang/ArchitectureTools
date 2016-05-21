package dg2.dmi.com.dagger2.dagger;

import dagger.Module;

/**
 * Created by gguser on 2/8/16.
 */
@Module
public class TestNetModule extends NetModule {
    public TestNetModule(String baseUrl) {
        super(baseUrl);
    }
}
