package com.dlgdev.xcom2tools.enemy_tracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.AppNavigationController;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.dagger.DaggerEnemyTrackerComponent;
import com.dlgdev.xcom2tools.dagger.EnemyTrackerModule;
import com.dlgdev.xcom2tools.domain.characters.BadGuysRepository;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EnemyTrackerActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	@Bind(R.id.drawer_layout) DrawerLayout drawer;
	@Bind(R.id.toolbar) Toolbar toolbar;
	@Bind(R.id.nav_view) NavigationView navigationView;

	@Bind(R.id.advents) RecyclerView adventUnits;
	@Bind(R.id.aliens) RecyclerView alienUnits;
	@Bind(R.id.roster) RecyclerView rosterView;
	@Bind(R.id.enemy_count) EditText enemyCount;

	@Inject AppNavigationController appNavigation;
	@Inject EnemyTrackerController controller;
	@Inject BadGuysRepository badGuysRepo;

	public static Intent intentFor(Context context) {
		return new Intent(context, EnemyTrackerActivity.class);
	}

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enemy_tracker);

		//Bind the injectable fields
		DaggerEnemyTrackerComponent.builder().enemyTrackerModule(new EnemyTrackerModule(this))
				.build().inject(this);

		ButterKnife.bind(this);
		setSupportActionBar(toolbar);
		setupDrawer();

		setupViews(adventUnits, alienUnits, rosterView);
	}

	private void setupDrawer() {
		ActionBarDrawerToggle toggle =
				new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
						R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		navigationView.setNavigationItemSelectedListener(this);
	}

	public void setupViews(RecyclerView adventUnitsView, RecyclerView alienUnitsView,
						   RecyclerView rosterView) {
		setupAdventUnits(adventUnitsView);
		setupAlienUnits(alienUnitsView);
		setupRosterUnits(rosterView);
	}

	private void setupAdventUnits(RecyclerView adventUnitsView) {
		setupRecyclerView(adventUnitsView);
		final List<Advent> advents = badGuysRepo.getPossibleAdvents();
		adventUnitsView.setAdapter(new AdventAdapter(advents, getLayoutInflater(),
				new ClickableViewHolder.RecyclerItemListener() {
					@Override public void onItemSelected(int position) {
						controller.onAdventSelected(advents.get(position));
					}
				}));
	}

	private void setupRecyclerView(RecyclerView recyclerView) {
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}

	private void setupAlienUnits(RecyclerView alienUnitsView) {
		setupRecyclerView(alienUnitsView);
		final List<Alien> aliens = badGuysRepo.getPossibleAliens();
		alienUnitsView.setAdapter(new AlienAdapter(aliens, getLayoutInflater(),
				new ClickableViewHolder.RecyclerItemListener() {
					@Override public void onItemSelected(int position) {
						controller.onAlienSelected(aliens.get(position));
					}
				}));
	}

	private void setupRosterUnits(RecyclerView rosterView) {
		setupRecyclerView(rosterView);
	}

	@Override public void onBackPressed() {
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.enemy_tracker, menu);
		return true;
	}

	@Override public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_settings:
				appNavigation.openSettings();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override public boolean onNavigationItemSelected(MenuItem item) {
		drawer.closeDrawer(GravityCompat.START);
		switch (item.getItemId()) {
			case R.id.nav_character_planner:
				appNavigation.openCharacterPlanner();
				break;
			//This 2 cases can be ignored from this point
			case R.id.nav_enemy_tracker:
			default:
		}
		return true;
	}
}
