package com.dlgdev.xcom2tools.views.mission_tracker;

import android.content.Intent;
import android.graphics.Color;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.BadGuysRoster;
import com.dlgdev.xcom2tools.domain.EnemiesRoster;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MissionTrackerActivityTest {

	@Rule public ActivityTestRule<MissionTrackerActivity> rule =
			new ActivityTestRule<>(MissionTrackerActivity.class, true, false);

	@Before public void setUp() throws Exception {
		BadGuysRoster roster = new EnemiesRoster();
		for(Alien alien : Alien.getAliens()) {
			roster.addEnemy(alien);
		}
		for(Advent advent : Advent.getAdvents()) {
			roster.addEnemy(advent);
		}

		Intent intent = new Intent();
		intent.putExtra(MissionTrackerActivity.EXTRA_ROSTER, roster.store());
		rule.launchActivity(intent);
	}

	@Test public void clickingOnACrowdedRecyclerMarksTheCorrectEnemyAsKilled() {
		onView(withText(R.string.lancer)).perform(click());
		onView(withText(R.string.lancer)).check(matches(hasTextColor(Color.RED)));
	}

	private Matcher<? super View> hasTextColor(final int color) {
		return new TypeSafeMatcher<View>() {
			@Override protected boolean matchesSafely(View item) {
				return ((TextView) item).getCurrentTextColor() == color;
			}

			@Override public void describeTo(Description description) {

			}
		};
	}
}