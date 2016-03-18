package com.dlgdev.xcom2tools.views.dagger;

import com.dlgdev.xcom2tools.views.AppNavigationController;
import com.dlgdev.xcom2tools.views.character_planner.CharacterPlannerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class CharacterPlannerModule {
	CharacterPlannerActivity activity;

	public CharacterPlannerModule(CharacterPlannerActivity activity) {
		this.activity = activity;
	}

	@Provides AppNavigationController provideNavigation() {
		return new AppNavigationController(activity);
	}
}