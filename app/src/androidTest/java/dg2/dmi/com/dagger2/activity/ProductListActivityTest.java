package dg2.dmi.com.dagger2.activity;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import dg2.dmi.com.dagger2.ApplicationTest;
import dg2.dmi.com.dagger2.R;
import dg2.dmi.com.dagger2.product.domain.Product;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;

/**
 * Created by gguser on 2/1/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProductListActivityTest {

    @Rule public ActivityTestRule<ProductListActivity> mRule =
            new ActivityTestRule<>(ProductListActivity.class,true,false);

    private MockWebServer mServer;
    private ArrayList<Product> mProducts;

    public ProductListActivityTest() {
        Product product1 = new Product();
        product1.setId(0L);
        product1.setTitle("Title 1");
        product1.setDescription("Description 1");
        Product product2 = new Product();
        product2.setId(1L);
        product2.setTitle("Title 2");
        product2.setDescription("Description 2");
        mProducts = new ArrayList<>(2);
        mProducts.add(product1);
        mProducts.add(product2);
    }

    @Before
    public void setUp() throws Exception {
        mServer = new MockWebServer();
        mServer.start();
        ApplicationTest.setBaseUrl(mServer.url("/").toString());
    }

    @Test
    public void resultShowInTheList() throws Exception {
        mServer.setDispatcher(getDispatcher());
        Intent intent = new Intent();
        mRule.launchActivity(intent);
        onView(withText(mProducts.get(1).getTitle())).check(matches(isDisplayed()));
    }

    @Test
    public void callProductsPath() throws Exception {
        mServer.setDispatcher(getDispatcher());
        Intent intent = new Intent();
        mRule.launchActivity(intent);
        RecordedRequest request1 = mServer.takeRequest();
        assertEquals("/products", request1.getPath());
    }

    @Test
    public void serverError() throws Exception {
        mServer.enqueue(new MockResponse().setResponseCode(500));
        Intent intent = new Intent();
        mRule.launchActivity(intent);
        String errorMessage = mRule.getActivity().getString(R.string.error_message);
        onView(withText(errorMessage))
                .check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        mServer.shutdown();
    }

    private Dispatcher getDispatcher() {
        return new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {

                if (request.getPath().equals("/products")){
                    return new MockResponse().setResponseCode(200)
                            .addHeader("Content-Type", "application/json; charset=utf-8")
                            .addHeader("Cache-Control", "no-cache")
                            .setBody(new Gson().toJson(mProducts));
                }
                return new MockResponse().setResponseCode(404);
            }
        };
    }
}
