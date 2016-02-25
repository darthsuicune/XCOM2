package com.dlgdev.xcom2tools.views.mission_tracker;

import android.os.Bundle;

import com.dlgdev.xcom2tools.views.AppNavigationController;
import com.dlgdev.xcom2tools.views.NavigationActivity;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.dagger.DaggerMissionTrackerComponent;
import com.dlgdev.xcom2tools.views.dagger.MissionTrackerModule;
import com.dlgdev.xcom2tools.domain.BadGuysRoster;

import javax.inject.Inject;

public class MissionTrackerActivity extends NavigationActivity {

	public static final String EXTRA_ROSTER = "roster";

	@Inject AppNavigationController appNavigation;
	@Inject BadGuysRoster roster;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DaggerMissionTrackerComponent.builder()
				.missionTrackerModule(new MissionTrackerModule(this)).build().inject(this);
		Bundle extras = getIntent().getExtras();
		if(extras.containsKey(EXTRA_ROSTER)) {
			roster.updateFromBundle(extras.getBundle(EXTRA_ROSTER));
		}
	}

	@Override protected int requestLayout() {
		return R.layout.activity_mission_tracker;
	}
}
