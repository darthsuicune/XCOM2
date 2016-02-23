package com.dlgdev.xcom2tools.enemy_tracker;

import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;

public interface EnemyTrackerController {
	void onAdventSelected(Advent advent);

	void onAlienSelected(Alien alien);
}
