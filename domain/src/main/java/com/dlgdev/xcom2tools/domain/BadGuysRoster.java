package com.dlgdev.xcom2tools.domain;

import android.os.Bundle;

import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

import java.util.List;

public interface BadGuysRoster {
	List<Enemy> enemyRoster();
	BadGuysRoster addEnemy(Enemy enemy);
	int amount();
	BadGuysRoster setAmount(int amount);

	Enemy getEnemy(int position);

	void removeEnemy(Enemy enemy);

	void updateFromBundle(Bundle bundle);

	Bundle store();

	void killEnemy(Enemy enemy);
	void reviveEnemy(Enemy enemy);
}
