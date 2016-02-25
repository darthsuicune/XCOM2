package com.dlgdev.xcom2tools.views.dagger;

import com.dlgdev.xcom2tools.views.enemy_tracker.EnemyTrackerActivity;

import dagger.Component;

@Component(modules={EnemyTrackerModule.class})
public interface EnemyTrackerComponent {
	void inject(EnemyTrackerActivity activity);
}
