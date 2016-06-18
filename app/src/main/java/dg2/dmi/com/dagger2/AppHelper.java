package dg2.dmi.com.dagger2;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by polenchheang on 6/12/16.
 */

public class AppHelper {
    @NonNull
    public static String getBaseUrl(Context context) {
        return getInstance(context).getBaseUrl();
    }

    public static Dagger2App getInstance(Context context) {
        return (Dagger2App)context.getApplicationContext();
    }
}
