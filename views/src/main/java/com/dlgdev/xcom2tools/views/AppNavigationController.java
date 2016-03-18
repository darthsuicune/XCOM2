package com.dlgdev.xcom2tools.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.views.character_planner.CharacterPlannerActivity;
import com.dlgdev.xcom2tools.views.enemy_tracker.EnemyTrackerActivity;
import com.dlgdev.xcom2tools.views.mission_tracker.MissionTrackerActivity;

import javax.inject.Inject;

public class AppNavigationController {
	Activity activity;

	@Inject public AppNavigationController(Activity activity) {
		this.activity = activity;
	}

	public void openSettings() {
		Toast.makeText(activity, R.string.error_unavailable, Toast.LENGTH_LONG).show();
	}

	public void openCharacterPlanner() {
		Intent intent = new Intent(activity, CharacterPlannerActivity.class);
		activity.startActivity(intent);
	}

	public void openEnemyTracker() {
		Intent intent = new Intent(activity, EnemyTrackerActivity.class);
		activity.startActivity(intent);
	}

	public void startMission(Bundle bundle) {
		Intent intent = new Intent(activity, MissionTrackerActivity.class);
		intent.putExtra(MissionTrackerActivity.EXTRA_ROSTER, bundle);
		activity.startActivity(intent);
	}
}
