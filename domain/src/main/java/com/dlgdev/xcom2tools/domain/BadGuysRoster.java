package com.dlgdev.xcom2tools.domain;

import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

import java.util.List;

public interface BadGuysRoster {
	List<Enemy> enemyRoster();
	BadGuysRoster addEnemy(Enemy enemy);
	int amount();
}
