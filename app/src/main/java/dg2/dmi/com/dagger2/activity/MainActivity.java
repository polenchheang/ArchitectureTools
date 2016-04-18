package dg2.dmi.com.dagger2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import javax.inject.Inject;

import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.dagger.AppModule;
import dg2.dmi.com.dagger2.dagger.DaggerGitHubComponent;
import dg2.dmi.com.dagger2.dagger.DaggerNetComponent;
import dg2.dmi.com.dagger2.dagger.GitHubModule;
import dg2.dmi.com.dagger2.dagger.NetComponent;
import dg2.dmi.com.dagger2.dagger.NetModule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    GitHubModule.GitHubInterface mGitHubInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetComponent netComponent = DaggerNetComponent
                .builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com")).build();

        DaggerGitHubComponent
                .builder()
                .netComponent(netComponent)
                .gitHubModule(new GitHubModule())
                .build().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Call<ArrayList<String>> repo = mGitHubInterface.getRepository("polen");
        repo.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                Log.d("Test","Success");
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Log.d("Test","Failed");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
