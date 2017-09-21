package com.example.swi.testapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UItest {


    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.txtPassword))
                .perform(typeText("HELLO"), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.txtPassword)).check(matches(withText("HELLO")));
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.txtUserName)).perform(typeText("Stefan@hotmail.com"),
                closeSoftKeyboard());

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.txtUserName)).check(matches(withText("Stefan@hotmail.com")));

        onView(withId(R.id.email_sign_in_button)).perform(click());
    }
}
