package dg2.dmi.com.dagger2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.dagger.GitHubModule;
import dg2.dmi.com.dagger2.dagger.GitHubComponentInjectable;
import dg2.dmi.com.dagger2.domain.GithubRepo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    GitHubModule.GitHubInterface mGitHubInterface;

    @Bind(R.id.text)
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        GitHubComponentInjectable.inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mGitHubInterface.getUser("linkedin")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GithubRepo>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this,"It's completed",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mText.setText("failed");
                        Toast.makeText(MainActivity.this,"It's error "+e.getMessage(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(GithubRepo githubRepo) {
                        mText.setText("success");
                        Toast.makeText(MainActivity.this,"It's next on "+githubRepo.getLogin(),Toast.LENGTH_LONG).show();
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
