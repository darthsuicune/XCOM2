package com.dlgdev.xcom2tools.domain;

import android.os.Bundle;

import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemiesRoster implements BadGuysRoster {
	private static final String KEY_AMOUNT = "Amount";
	private static final String KEY_ALIENS = "Enemies";
	private static final String KEY_ADVENTS = "Enemies";

	List<Enemy> enemies = new ArrayList<>();
	int amount = 0;

	@Override public List<Enemy> enemyRoster() {
		return enemies;
	}

	@Override public BadGuysRoster addEnemy(Enemy enemy) {
		enemies.add(enemy);
		return this;
	}

	@Override public int amount() {
		return amount;
	}

	@Override public BadGuysRoster setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	@Override public Enemy getEnemy(int position) {
		return enemies.get(position);
	}

	@Override public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}

	@Override public void updateFromBundle(Bundle bundle) {
		this.amount = bundle.getInt(KEY_AMOUNT);
	}

	@Override public Bundle store() {
		Bundle bundle = new Bundle();
		bundle.putInt(KEY_AMOUNT, amount);
		return bundle;
	}
}
