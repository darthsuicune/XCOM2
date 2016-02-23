package com.dlgdev.xcom2tools.domain.characters;

import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;
import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

import java.util.List;

public interface BadGuysRepository {
	List<Enemy> getPossibleEnemies();
	List<Alien> getPossibleAliens();
	List<Advent> getPossibleAdvents();
}
