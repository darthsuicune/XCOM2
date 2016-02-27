package com.dlgdev.xcom2tools.domain;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;
import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemiesRoster implements BadGuysRoster {
	private static final String KEY_AMOUNT = "Amount";
	private static final String KEY_ENEMIES = "Enemies";
	private static final String KEY_KILLED_ENEMIES = "KilledEnemies";

	List<Enemy> enemies = new ArrayList<>();
	List<Enemy> killedEnemies = new ArrayList<>();
	int amount = 0;

	@Override public List<Enemy> enemyRoster() {
		return enemies;
	}

	@Override public BadGuysRoster addEnemy(Enemy enemy) {
		if(!enemies.contains(enemy)) {
			enemies.add(enemy);
		}
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

	@Override public void killEnemy(Enemy enemy) {
		amount--;
		killedEnemies.add(enemy);
	}

	@Override public void updateFromBundle(Bundle bundle) {
		this.amount = bundle.getInt(KEY_AMOUNT);
		List<Integer> enemies = bundle.getIntegerArrayList(KEY_ENEMIES);
		addEnemiesFromIdsToList(enemies, this.enemies);
		List<Integer> killed = bundle.getIntegerArrayList(KEY_KILLED_ENEMIES);
		addEnemiesFromIdsToList(killed, this.killedEnemies);
	}

	public void addEnemiesFromIdsToList(List<Integer> ids, List<Enemy> list) {
		if (ids == null) {
			throw new IllegalStateException("The lists weren't properly saved, you moron");
		}
		for (Integer id : ids) {
			list.add(Alien.fromId(id));
		}
	}

	@Override public Bundle store() {
		Bundle bundle = new Bundle();
		bundle.putInt(KEY_AMOUNT, amount);
		ArrayList<Integer> enemyIds = getIdsFromList(this.enemies);
		bundle.putIntegerArrayList(KEY_ENEMIES, enemyIds);
		ArrayList<Integer> killedEnemiesIds = getIdsFromList(this.killedEnemies);
		bundle.putIntegerArrayList(KEY_KILLED_ENEMIES, killedEnemiesIds);
		return bundle;
	}

	@NonNull private ArrayList<Integer> getIdsFromList(List<Enemy> list) {
		ArrayList<Integer> enemyIds = new ArrayList<>(25);
		for(Enemy enemy : list) {
			enemyIds.add(enemy.nameResId());
		}
		return enemyIds;
	}
}
