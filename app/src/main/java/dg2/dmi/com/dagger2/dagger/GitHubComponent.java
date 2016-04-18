package dg2.dmi.com.dagger2.dagger;

import dagger.Component;
import dg2.dmi.com.dagger2.activity.MainActivity;

/**
 * Created by gguser on 4/18/16.
 */
@UserScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(MainActivity activity);
}
