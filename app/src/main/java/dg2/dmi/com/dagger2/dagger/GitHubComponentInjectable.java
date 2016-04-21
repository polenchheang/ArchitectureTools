package dg2.dmi.com.dagger2.dagger;

import dg2.dmi.com.dagger2.Dagger2App;
import dg2.dmi.com.dagger2.activity.MainActivity;

/**
 * Created by polenchheang on 4/21/16.
 */
public class GitHubComponentInjectable {
    public static void inject(MainActivity activity) {
        ((Dagger2App) activity.getApplicationContext()).getGitHubComponent().inject(activity);
    }
}
