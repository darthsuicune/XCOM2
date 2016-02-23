package com.dlgdev.xcom2tools.domain.characters.badguys;

public class Alien extends Enemy {
	public String name;
	public Alien(String name) {
		this.name = name;
	}
	@Override public String name() {
		return name;
	}
}
