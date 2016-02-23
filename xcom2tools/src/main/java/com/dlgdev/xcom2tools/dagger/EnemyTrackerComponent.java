package com.dlgdev.xcom2tools.dagger;

import com.dlgdev.xcom2tools.enemy_tracker.EnemyTrackerActivity;

import dagger.Component;

@Component(modules={EnemyTrackerModule.class})
public interface EnemyTrackerComponent {
	void inject(EnemyTrackerActivity activity);
}
