package com.dlgdev.xcom2tools.domain.characters.badguys;

import com.dlgdev.xcom2tools.domain.characters.BadGuysRepository;

import java.util.List;
import java.util.Map;

public class BadGuysRepo implements BadGuysRepository {

	public Map<Enemy, Integer> getEnemies() {
		return null;
	}

	@Override public List<Enemy> getPossibleEnemies() {
		return null;
	}

	@Override public List<Alien> getPossibleAliens() {
		return Aliens.getAliens();
	}

	@Override public List<Advent> getPossibleAdvents() {
		return Advents.getAdvents();
	}
}
