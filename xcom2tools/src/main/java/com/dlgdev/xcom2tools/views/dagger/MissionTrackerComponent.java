package com.dlgdev.xcom2tools.views.dagger;

import com.dlgdev.xcom2tools.views.mission_tracker.MissionTrackerActivity;

import dagger.Component;

@Component(modules= {MissionTrackerModule.class})
public interface MissionTrackerComponent {
	void inject(MissionTrackerActivity activity);
}
