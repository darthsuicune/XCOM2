package com.dlgdev.xcom2tools.domain.characters.badguys;

import com.dlgdev.xcom2tools.domain.R;

import java.util.ArrayList;
import java.util.List;

public enum Advent implements Enemy {
	TROOPER(R.string.trooper), ADVANCED_TROOPER(R.string.advanced_trooper), LANCER(R.string.lancer),
	HEAVY_LANCER(R.string.heavy_lancer), OFFICER(R.string.officer),
	ADVANCED_OFFICER(R.string.advanced_officer), SHIELDBEARER(R.string.shieldbearer),
	ELITE_SHIELDBEARER(R.string.elite_shieldbearer), MEC(R.string.mec),
	HEAVY_MEC(R.string.heavy_mec), AVATAR(R.string.avatar);

	int nameResId;

	Advent(int nameResId) {
		this.nameResId = nameResId;
	}

	@Override public int nameResId() {
		return this.nameResId;
	}

	public static List<Advent> getAdvents() {
		List<Advent> list = new ArrayList<>(10);
		list.add(TROOPER);
		list.add(ADVANCED_TROOPER);
		list.add(LANCER);
		list.add(HEAVY_LANCER);
		list.add(OFFICER);
		list.add(ADVANCED_OFFICER);
		list.add(SHIELDBEARER);
		list.add(ELITE_SHIELDBEARER);
		list.add(MEC);
		list.add(HEAVY_MEC);
		list.add(AVATAR);
		return list;
	}

	public static Enemy fromId(Integer id) {
		if (R.string.trooper == id) {
			return TROOPER;
		} else if (R.string.advanced_trooper == id) {
			return ADVANCED_TROOPER;
		} else if (R.string.lancer == id) {
			return LANCER;
		} else if (R.string.heavy_lancer == id) {
			return HEAVY_LANCER;
		} else if (R.string.officer == id) {
			return OFFICER;
		} else if (R.string.advanced_officer == id) {
			return ADVANCED_OFFICER;
		} else if (R.string.shieldbearer == id) {
			return SHIELDBEARER;
		} else if (R.string.elite_shieldbearer == id) {
			return ELITE_SHIELDBEARER;
		} else if (R.string.mec == id) {
			return MEC;
		} else if (R.string.heavy_mec == id) {
			return HEAVY_MEC;
		} else if (R.string.avatar == id) {
			return AVATAR;
		} else {
			return TROOPER;
		}
	}
}
