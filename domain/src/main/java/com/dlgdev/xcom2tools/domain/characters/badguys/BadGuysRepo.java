package com.dlgdev.xcom2tools.domain.characters.badguys;

import com.dlgdev.xcom2tools.domain.characters.BadGuysRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class BadGuysRepo implements BadGuysRepository {

	@Inject public BadGuysRepo() {

	}

	public Map<Enemy, Integer> getEnemies() {
		return null;
	}

	@Override public List<Enemy> getPossibleEnemies() {
		return null;
	}

	@Override public List<Alien> getPossibleAliens() {
		List<Alien> aliens = new ArrayList<>();
		aliens.add(new Alien("Sectopod"));
		return aliens;
	}

	@Override public List<Advent> getPossibleAdvents() {
		List<Advent> advents = new ArrayList<>();
		advents.add(new Advent("Shieldbearer"));
		return advents;
	}
}
