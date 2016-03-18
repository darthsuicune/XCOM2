package com.dlgdev.xcom2tools.views.enemy_tracker;

import android.os.Bundle;

import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;
import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

public interface EnemyTrackerController {
	void onAdventSelected(Advent advent);

	void onAlienSelected(Alien alien);

	void onEnemyFromRosterSelected(Enemy enemy);

	Bundle storeRoster();

	void restoreRoster(Bundle bundle);

	void setEnemyAmount(int amount);

	void changeEnemyCountBy(int i);
}
