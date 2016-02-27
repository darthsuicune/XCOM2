package com.dlgdev.xcom2tools.views.enemy_tracker;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.BadGuysRoster;
import com.dlgdev.xcom2tools.domain.characters.BadGuysRepository;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;
import com.dlgdev.xcom2tools.views.NavigationActivity;
import com.dlgdev.xcom2tools.views.dagger.DaggerEnemyTrackerComponent;
import com.dlgdev.xcom2tools.views.dagger.EnemyTrackerComponent;
import com.dlgdev.xcom2tools.views.dagger.EnemyTrackerModule;
import com.dlgdev.xcom2tools.views.enemies.AdventAdapter;
import com.dlgdev.xcom2tools.views.enemies.AlienAdapter;
import com.dlgdev.xcom2tools.views.enemies.RosterAdapter;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class EnemyTrackerActivity extends NavigationActivity implements EnemyTrackerActions {

	private static final String KEY_ROSTER = "roster";

	@Bind(R.id.advents) RecyclerView adventUnitsView;
	@Bind(R.id.aliens) RecyclerView alienUnitsView;
	@Bind(R.id.roster) RecyclerView rosterView;
	@Bind(R.id.enemy_count) EditText enemyCount;

	@Inject EnemyTrackerController controller;
	@Inject BadGuysRepository badGuysRepo;
	RosterAdapter adapter;

	EnemyTrackerComponent component;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		component = DaggerEnemyTrackerComponent.builder().enemyTrackerModule(new EnemyTrackerModule(this))
				.build();
		component.inject(this);
		setTitle(R.string.enemy_tracker_title);
		setupViews();
		if (savedInstanceState != null && savedInstanceState.containsKey(KEY_ROSTER)) {
			controller.restoreRoster(savedInstanceState.getBundle(KEY_ROSTER));
		}
	}

	@Override protected int requestLayout() {
		return R.layout.activity_enemy_tracker;
	}

	public void setupViews() {
		setupAdventUnits();
		setupAlienUnits();
		setupRosterUnits();
		enemyCount.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override public void afterTextChanged(Editable editable) {
				try {
					controller.setEnemyAmount(Integer.parseInt(editable.toString()));
					enemyCount.setError(null);
				} catch (NumberFormatException e) {
					enemyCount.setError(getString(R.string.error_invalid_enemy_count));
				}

			}
		});
	}

	@Override protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBundle(KEY_ROSTER, controller.storeRoster());
	}

	private void setupAdventUnits() {
		setupRecyclerView(adventUnitsView);
		final List<Advent> advents = badGuysRepo.getPossibleAdvents();
		AdventAdapter adapter = new AdventAdapter(advents, getLayoutInflater(),
				new ClickableViewHolder.RecyclerItemListener() {
					@Override public void onItemSelected(int position) {
						controller.onAdventSelected(advents.get(position));
					}
				});
		adventUnitsView.setAdapter(adapter);
	}

	private void setupRecyclerView(RecyclerView recyclerView) {
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}

	private void setupAlienUnits() {
		setupRecyclerView(alienUnitsView);
		final List<Alien> aliens = badGuysRepo.getPossibleAliens();
		alienUnitsView.setAdapter(new AlienAdapter(aliens, getLayoutInflater(),
				new ClickableViewHolder.RecyclerItemListener() {
					@Override public void onItemSelected(int position) {
						controller.onAlienSelected(aliens.get(position));
					}
				}));
	}

	private void setupRosterUnits() {
		setupRecyclerView(rosterView);
		adapter = new RosterAdapter(component.provideRoster(), getLayoutInflater(),
				new ClickableViewHolder.RecyclerItemListener() {
					@Override public void onItemSelected(int position) {
						controller.onEnemyFromRosterSelected(position);
					}
				});
		rosterView.setAdapter(adapter);
	}


	@Override public void updateRoster(final BadGuysRoster roster) {
		adapter.updateRoster(roster);
		enemyCount.setText(String.format(Locale.getDefault(), "%d", roster.amount()));
	}

	@OnClick(R.id.start_mission) public void startMission() {
		if (TextUtils.isEmpty(enemyCount.getText())) {
			controller.setEnemyAmount(0);
		}
		appNavigation.startMission(controller.storeRoster());
	}

	@OnClick(R.id.add_enemy) public void addEnemy() {
		controller.changeEnemyCountBy(1);
	}

	@OnClick(R.id.remove_enemy) public void removeEnemy() {
		controller.changeEnemyCountBy(-1);
	}
}
