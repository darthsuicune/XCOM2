package com.dlgdev.xcom2tools.domain.characters.badguys;

public abstract class Enemy {
	private int nameResId;

	public Enemy(int nameResId) {
		this.nameResId = nameResId;
	}
	public int name() {
		return this.nameResId;
	}
}
