package com.dlgdev.xcom2tools.views.dagger;

import com.dlgdev.xcom2tools.views.AppNavigationController;
import com.dlgdev.xcom2tools.domain.BadGuysRoster;
import com.dlgdev.xcom2tools.domain.EnemiesRoster;
import com.dlgdev.xcom2tools.views.mission_tracker.MissionTrackerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MissionTrackerModule {
	private MissionTrackerActivity activity;

	public MissionTrackerModule(MissionTrackerActivity activity) {
		this.activity = activity;
	}

	@Provides AppNavigationController provideNavigation() {
		return new AppNavigationController(activity);
	}

	@Provides BadGuysRoster provideRoster() {
		return new EnemiesRoster();
	}
}
