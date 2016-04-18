package dg2.dmi.com.dagger2.dagger;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gguser on 4/18/16.
 */
@Module
public class GitHubModule {
    public interface GitHubInterface {
        @GET("org/{orgName}/repos")
        Call<ArrayList<String>> getRepository(@Path("orgName") String orgName);
    }

    @Provides
    @UserScope
    public GitHubInterface provideGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubInterface.class);
    }
}
