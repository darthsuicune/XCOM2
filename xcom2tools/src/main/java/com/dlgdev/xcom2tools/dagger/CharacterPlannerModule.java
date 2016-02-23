package com.dlgdev.xcom2tools.dagger;

import com.dlgdev.xcom2tools.AppNavigationController;
import com.dlgdev.xcom2tools.character_planner.CharacterPlannerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class CharacterPlannerModule {
	CharacterPlannerActivity activity;

	CharacterPlannerModule(CharacterPlannerActivity activity) {
		this.activity = activity;
	}

	@Provides AppNavigationController provideNavigation() {
		return new AppNavigationController(activity);
	}
}