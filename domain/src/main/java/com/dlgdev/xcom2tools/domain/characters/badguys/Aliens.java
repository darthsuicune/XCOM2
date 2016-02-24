package com.dlgdev.xcom2tools.domain.characters.badguys;

import com.dlgdev.xcom2tools.domain.R;

import java.util.ArrayList;
import java.util.List;

public enum Aliens {
	SECTOID(R.string.sectoid), VIPER(R.string.viper), ARCHON(R.string.archon),
	CODEX(R.string.codex), CHRYSSALID(R.string.chryssalid),
	BABY_CHRYSSALID(R.string.baby_chryssalid), ANDROMEDON(R.string.andromedon),
	SECTOPOD(R.string.sectopod), GATEKEEPER(R.string.gatekeeper), AVATAR(R.string.avatar);

	Alien alien;

	Aliens(int nameResId) {
		alien = new Alien(nameResId);
	}

	public static List<Alien> getAliens() {
		List<Alien> list = new ArrayList<>(10);
		list.add(SECTOID.alien);
		list.add(VIPER.alien);
		list.add(ARCHON.alien);
		list.add(CODEX.alien);
		list.add(CHRYSSALID.alien);
		list.add(BABY_CHRYSSALID.alien);
		list.add(ANDROMEDON.alien);
		list.add(SECTOPOD.alien);
		list.add(GATEKEEPER.alien);
		list.add(AVATAR.alien);
		return list;
	}
}
