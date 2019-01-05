package com.example.loic.comics_app_android;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.loic.comics_app_android.presentation.ui.activity.ComicListActivity;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.lpiem.comic.android", appContext.getPackageName());
    }

    @BeforeClass
    public static void beforeAll() {
        Screengrab.setDefaultScreenshotStrategy(new UiAutomatorScreenshotStrategy());
    }

    @ClassRule
    public static final LocaleTestRule localeTestRule = new LocaleTestRule();

    @Rule
    public ActivityTestRule<ComicListActivity> activityRule = new ActivityTestRule<>(ComicListActivity.class);

    @Test
    public void testTakeScreenshot() {
        appSleep(2000);
        Screengrab.screenshot("comic-list");
        onView(withId(R.id.comics_list_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        appSleep(2000);
        Screengrab.screenshot("comic-detail");
    }

    private static void appSleep(int i){
        try{
            Thread.sleep(i);
        }catch(InterruptedException e){
        }
    }
}
