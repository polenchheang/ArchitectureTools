package dg2.dmi.com.dagger2.dagger;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import dg2.dmi.com.dagger2.dagger.scope.UserScope;
import dg2.dmi.com.dagger2.domain.Product;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by gguser on 4/18/16.
 */
@Module
public class GitHubModule {
    public interface GitHubInterface {
        @GET("/products")
        Observable<List<Product>> getProductList();
    }

    @Provides
    @UserScope
    public GitHubInterface provideGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubInterface.class);
    }
}
