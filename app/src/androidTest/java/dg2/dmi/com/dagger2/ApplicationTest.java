package dg2.dmi.com.dagger2;

import android.support.annotation.NonNull;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends Dagger2App {
    private static String mBaseUrlTest;

    @NonNull
    @Override
    public String getBaseUrl() {
        return mBaseUrlTest;
    }

    public static void setBaseUrl(String baseUrl) {
        mBaseUrlTest = baseUrl;
    }
}