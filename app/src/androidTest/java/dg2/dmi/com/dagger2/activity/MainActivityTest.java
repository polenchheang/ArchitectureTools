package dg2.dmi.com.dagger2.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import dg2.dmi.com.dagger2.ApplicationTest;
import dg2.dmi.com.dagger2.domain.DummyObject;

/**
 * Created by gguser on 2/1/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Inject
    DummyObject mDummyObject;

    @Before
    public void setUp() throws Exception {
        ((ApplicationTest)mActivityTestRule.getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Test
    public void testDummyObject() throws Exception {
        Assert.assertEquals(mDummyObject.getText(),"Is Test");
    }
}
