package dg2.dmi.com.dagger2.activity;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dg2.dmi.com.dagger2.ApplicationTest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by gguser on 2/1/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class,true,false);

    private MockWebServer mServer;

    @Before
    public void setUp() throws Exception {
        mServer = new MockWebServer();
        mServer.start();
        ApplicationTest.setBaseUrl(mServer.url("/").toString());
        Log.i("polenTest","DoneSetBaseUrl ");
    }

    @Test
    public void testMockServer() throws Exception {
        mServer.enqueue(new MockResponse().setResponseCode(200).setBody("[{\"id\":0,\"title\":\"Title 1\",\"description\":\"Description 1\"},{\"id\":1,\"title\":\"Title 2\",\"description\":\"Description 2\"}]"));
        Intent intent = new Intent();
        mActivityTestRule.launchActivity(intent);
        Log.i("polenTest","launchActivity");
        onView(withText("Title 2")).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        mServer.shutdown();
    }
}
