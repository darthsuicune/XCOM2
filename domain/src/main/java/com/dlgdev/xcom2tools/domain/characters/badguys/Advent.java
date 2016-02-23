package com.dlgdev.xcom2tools.domain.characters.badguys;

public class Advent extends Enemy {
	public String name;
	public Advent(String name) {
		this.name = name;
	}
	@Override public String name() {
		return name;
	}
}
