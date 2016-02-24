package com.dlgdev.xcom2tools.domain.characters.badguys;

import com.dlgdev.xcom2tools.domain.R;

import java.util.ArrayList;
import java.util.List;

public enum Advents {
	TROOPER(R.string.trooper), ADVANCED_TROOPER(R.string.advanced_trooper), LANCER(R.string.lancer),
	HEAVY_LANCER(R.string.heavy_lancer), OFFICER(R.string.officer),
	ADVANCED_OFFICER(R.string.advanced_officer), SHIELDBEARER(R.string.shieldbearer),
	ELITE_SHIELDBEARER(R.string.elite_shieldbearer), MEC(R.string.mec),
	HEAVY_MEC(R.string.heavy_mec);

	Advent advent;

	Advents(int nameResId) {
		advent = new Advent(nameResId);
	}

	public static List<Advent> getAdvents() {
		List<Advent> list = new ArrayList<>(10);
		list.add(TROOPER.advent);
		list.add(ADVANCED_TROOPER.advent);
		list.add(LANCER.advent);
		list.add(HEAVY_LANCER.advent);
		list.add(OFFICER.advent);
		list.add(ADVANCED_OFFICER.advent);
		list.add(SHIELDBEARER.advent);
		list.add(ELITE_SHIELDBEARER.advent);
		list.add(MEC.advent);
		list.add(HEAVY_MEC.advent);
		return list;
	}
}
