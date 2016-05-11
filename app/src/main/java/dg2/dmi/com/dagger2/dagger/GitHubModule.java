package dg2.dmi.com.dagger2.dagger;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.Dagger2App;
import dg2.dmi.com.dagger2.activity.MainActivity;
import dg2.dmi.com.dagger2.dagger.scope.UserScope;
import dg2.dmi.com.dagger2.domain.GithubRepo;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by gguser on 4/18/16.
 */
@Module
public class GitHubModule {
    public interface GitHubInterface {
        @GET("/users/{login}")
        Observable<GithubRepo> getUser(@Path("login") String login);
    }

    @Provides
    @UserScope
    public GitHubInterface provideGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubInterface.class);
    }
}
