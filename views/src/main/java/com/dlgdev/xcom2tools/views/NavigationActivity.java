package com.dlgdev.xcom2tools.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.views.character_planner.CharacterPlannerActivity;
import com.dlgdev.xcom2tools.views.enemy_tracker.EnemyTrackerActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class NavigationActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	@Bind(R.id.drawer_layout) DrawerLayout drawer;
	@Bind(R.id.toolbar) Toolbar toolbar;
	@Bind(R.id.nav_view) NavigationView navigationView;

	@Inject protected AppNavigationController appNavigation;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(requestLayout());
		ButterKnife.bind(this);

		setSupportActionBar(toolbar);
		setupNavigationDrawer();
	}

	protected abstract int requestLayout();

	@Override public void onBackPressed() {
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	private void setupNavigationDrawer() {
		ActionBarDrawerToggle toggle =
				new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
						R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		navigationView.setNavigationItemSelectedListener(this);
	}

	@Override public boolean onNavigationItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.nav_enemy_tracker:
				if(!(this instanceof EnemyTrackerActivity)) {
					appNavigation.openEnemyTracker();
				}
				break;
			case R.id.nav_character_planner:
				if(!(this instanceof CharacterPlannerActivity)) {
					appNavigation.openCharacterPlanner();
				}
				break;
		}
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@Override public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.common, menu);
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
}
