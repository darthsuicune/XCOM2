package com.dlgdev.xcom2tools.dagger;

import com.dlgdev.xcom2tools.character_planner.CharacterPlannerActivity;

import dagger.Component;

@Component(modules={CharacterPlannerModule.class})
public interface CharacterPlannerComponent {
	void inject(CharacterPlannerActivity activity);
}
