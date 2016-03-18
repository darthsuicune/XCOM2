package com.dlgdev.xcom2tools.views.dagger;

import com.dlgdev.xcom2tools.views.character_planner.CharacterPlannerActivity;

import dagger.Component;

@Component(modules={CharacterPlannerModule.class})
public interface CharacterPlannerComponent {
	void inject(CharacterPlannerActivity activity);
}
