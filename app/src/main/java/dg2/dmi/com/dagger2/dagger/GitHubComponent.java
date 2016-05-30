package dg2.dmi.com.dagger2.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gguser on 4/18/16.
 */
@Singleton
@Component(
        dependencies = NetComponent.class,
        modules = {
                GitHubModule.class
        }
)
public interface GitHubComponent {
//    void inject(MainActivity activity);
    GitHubModule.GitHubInterface getGitHubInterface();
}
