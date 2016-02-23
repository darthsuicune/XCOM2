package com.dlgdev.xcom2tools.enemy_tracker;

import android.support.design.widget.Snackbar;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;

import javax.inject.Inject;

public class EnemyTrackerControllerImpl implements EnemyTrackerController {

	private EnemyTrackerActivity activity;

	@Inject public EnemyTrackerControllerImpl(EnemyTrackerActivity activity) {
		this.activity = activity;
	}

	@Override public void onAdventSelected(Advent advent) {
		Snackbar.make(activity.findViewById(R.id.toolbar), "Advent selected!", Snackbar.LENGTH_LONG).show();
	}

	@Override public void onAlienSelected(Alien alien) {
		Snackbar.make(activity.findViewById(R.id.toolbar), "Alien selected!", Snackbar.LENGTH_LONG).show();
	}
}
