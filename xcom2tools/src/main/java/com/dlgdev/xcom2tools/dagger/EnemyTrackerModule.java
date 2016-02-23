package com.dlgdev.xcom2tools.dagger;

import com.dlgdev.xcom2tools.AppNavigationController;
import com.dlgdev.xcom2tools.domain.characters.BadGuysRepository;
import com.dlgdev.xcom2tools.domain.characters.badguys.BadGuysRepo;
import com.dlgdev.xcom2tools.enemy_tracker.EnemyTrackerActivity;
import com.dlgdev.xcom2tools.enemy_tracker.EnemyTrackerController;
import com.dlgdev.xcom2tools.enemy_tracker.EnemyTrackerControllerImpl;

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

	@Provides EnemyTrackerActivity provideActivity() {
		return activity;
	}

	@Provides EnemyTrackerController provideController(EnemyTrackerControllerImpl impl) {
		return impl;
	}

	@Provides BadGuysRepository provideRepository(BadGuysRepo repo) {
		return repo;
	}
}
