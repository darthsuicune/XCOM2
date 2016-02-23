package com.dlgdev.xcom2tools;

import android.app.Activity;

import com.dlgdev.xcom2tools.character_planner.CharacterPlannerActivity;
import com.dlgdev.xcom2tools.enemy_tracker.EnemyTrackerActivity;

import javax.inject.Inject;

public class AppNavigationController {
	Activity activity;

	@Inject public AppNavigationController(Activity activity) {
		this.activity = activity;
	}

	public void openSettings() {
		//Not available as of now
	}

	public void openCharacterPlanner() {
		activity.startActivity(CharacterPlannerActivity.intentFor(activity));
	}

	public void openEnemyTracker() {
		activity.startActivity(EnemyTrackerActivity.intentFor(activity));
	}
}
