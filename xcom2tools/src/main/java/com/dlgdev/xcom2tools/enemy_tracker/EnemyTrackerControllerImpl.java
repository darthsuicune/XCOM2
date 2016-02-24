package com.dlgdev.xcom2tools.enemy_tracker;

import android.os.Bundle;

import com.dlgdev.xcom2tools.domain.BadGuysRoster;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;
import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

import javax.inject.Inject;

public class EnemyTrackerControllerImpl implements EnemyTrackerController {

	EnemyTrackerActions activity;
	BadGuysRoster roster;

	@Inject public EnemyTrackerControllerImpl(EnemyTrackerActions activity, BadGuysRoster roster) {
		this.activity = activity;
		this.roster = roster;
	}

	@Override public void onAdventSelected(Advent advent) {
		roster.addEnemy(advent);
		activity.updateRoster(roster);
	}

	@Override public void onAlienSelected(Alien alien) {
		roster.addEnemy(alien);
		activity.updateRoster(roster);
	}

	@Override public void onEnemyFromRosterSelected(Enemy enemy) {
		roster.removeEnemy(enemy);
		activity.updateRoster(roster);
	}

	@Override public Bundle storeRoster() {
		return roster.store();
	}

	@Override public void restoreRoster(Bundle bundle) {
		roster.updateFromBundle(bundle);
		activity.updateRoster(roster);
	}
}
