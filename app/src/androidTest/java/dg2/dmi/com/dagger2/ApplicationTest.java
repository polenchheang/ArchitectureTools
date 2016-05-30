package dg2.dmi.com.dagger2;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends Dagger2App {
    private static String mBaseUrlTest = "https://api.github.com";

    @NonNull
    @Override
    public String getBaseUrl() {
        Log.i("polenTest","BaseUrl get is " + mBaseUrlTest);
        return mBaseUrlTest;
    }

    public static void setBaseUrl(String baseUrl) {
        Log.i("polenTest","BaseUrl set is " + baseUrl);
        mBaseUrlTest = baseUrl;
    }
}