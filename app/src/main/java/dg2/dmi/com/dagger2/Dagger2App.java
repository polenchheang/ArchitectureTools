package dg2.dmi.com.dagger2;

import android.app.Application;
import android.support.annotation.NonNull;

import dg2.dmi.com.dagger2.dagger.AppModule;
import dg2.dmi.com.dagger2.dagger.DaggerGitHubComponent;
import dg2.dmi.com.dagger2.dagger.DaggerNetComponent;
import dg2.dmi.com.dagger2.dagger.GitHubComponent;
import dg2.dmi.com.dagger2.dagger.GitHubModule;
import dg2.dmi.com.dagger2.dagger.NetComponent;
import dg2.dmi.com.dagger2.dagger.NetModule;

/**
 * Created by gguser on 1/29/16.
 */
public class Dagger2App extends Application {

    private GitHubComponent mGitHubComponent;

    private void initializeGitHubComponent() {
        NetComponent netComponent = DaggerNetComponent
                .builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(getBaseUrl())).build();

        mGitHubComponent = DaggerGitHubComponent
                .builder()
                .netComponent(netComponent)
                .gitHubModule(new GitHubModule())
                .build();
    }

    @NonNull
    protected String getBaseUrl() {
        return BuildConfig.ENDPOINT;
    }

    public GitHubComponent getGitHubComponent() {
        if (mGitHubComponent == null) {
            initializeGitHubComponent();
        }
        return mGitHubComponent;
    }

}
