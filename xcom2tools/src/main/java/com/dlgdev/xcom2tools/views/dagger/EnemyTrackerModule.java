package com.dlgdev.xcom2tools.views.dagger;

import com.dlgdev.xcom2tools.views.AppNavigationController;
import com.dlgdev.xcom2tools.domain.BadGuysRoster;
import com.dlgdev.xcom2tools.domain.EnemiesRoster;
import com.dlgdev.xcom2tools.domain.characters.BadGuysRepository;
import com.dlgdev.xcom2tools.domain.characters.badguys.BadGuysRepo;
import com.dlgdev.xcom2tools.views.enemy_tracker.EnemyTrackerActions;
import com.dlgdev.xcom2tools.views.enemy_tracker.EnemyTrackerActivity;
import com.dlgdev.xcom2tools.views.enemy_tracker.EnemyTrackerController;
import com.dlgdev.xcom2tools.views.enemy_tracker.EnemyTrackerControllerImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class EnemyTrackerModule {
	EnemyTrackerActivity activity;

	public EnemyTrackerModule(EnemyTrackerActivity activity) {
		this.activity = activity;
	}

	@Provides AppNavigationController provideNavigation() {
		return new AppNavigationController(activity);
	}

	@Provides EnemyTrackerActions provideActivity() {
		return activity;
	}

	@Provides EnemyTrackerController provideController(EnemyTrackerControllerImpl impl) {
		return impl;
	}

	@Provides BadGuysRepository provideRepository() {
		return new BadGuysRepo();
	}

	@Provides BadGuysRoster provideRoster() {
		return new EnemiesRoster();
	}
}
