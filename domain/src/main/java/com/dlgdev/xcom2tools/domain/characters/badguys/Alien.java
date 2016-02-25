package com.dlgdev.xcom2tools.domain.characters.badguys;

import com.dlgdev.xcom2tools.domain.R;

import java.util.ArrayList;
import java.util.List;

public enum Alien implements Enemy {
	SECTOID(R.string.sectoid), VIPER(R.string.viper), ARCHON(R.string.archon),
	MUTON(R.string.muton), CODEX(R.string.codex), CHRYSSALID(R.string.chryssalid),
	BABY_CHRYSSALID(R.string.baby_chryssalid), ANDROMEDON(R.string.andromedon),
	SECTOPOD(R.string.sectopod), GATEKEEPER(R.string.gatekeeper);

	int nameResId;

	Alien(int nameResId) {
		this.nameResId = nameResId;
	}

	@Override public int nameResId() {
		return nameResId;
	}

	public static List<Alien> getAliens() {
		List<Alien> list = new ArrayList<>(10);
		list.add(SECTOID);
		list.add(VIPER);
		list.add(MUTON);
		list.add(ARCHON);
		list.add(CODEX);
		list.add(CHRYSSALID);
		list.add(BABY_CHRYSSALID);
		list.add(ANDROMEDON);
		list.add(SECTOPOD);
		list.add(GATEKEEPER);
		return list;
	}

	public static Enemy fromId(Integer id) {
		if (R.string.sectoid == id) {
			return SECTOID;
		} else if (R.string.viper == id) {
			return VIPER;
		} else if (R.string.archon == id) {
			return ARCHON;
		} else if (R.string.muton == id) {
			return MUTON;
		} else if (R.string.codex == id) {
			return CODEX;
		} else if (R.string.chryssalid == id) {
			return CHRYSSALID;
		} else if (R.string.baby_chryssalid == id) {
			return BABY_CHRYSSALID;
		} else if (R.string.andromedon == id) {
			return ANDROMEDON;
		} else if (R.string.sectopod == id) {
			return SECTOPOD;
		} else if (R.string.gatekeeper == id) {
			return GATEKEEPER;
		} else {
			return Advent.fromId(id);
		}
	}
}
