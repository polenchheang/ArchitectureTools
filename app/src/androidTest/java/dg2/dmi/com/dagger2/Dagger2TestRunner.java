package dg2.dmi.com.dagger2;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by gguser on 2/8/16.
 */
public class Dagger2TestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl,
                ApplicationTest.class.getCanonicalName(),
                context);
    }

}
