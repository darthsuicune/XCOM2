package com.dlgdev.xcom2tools.character_planner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dlgdev.xcom2tools.AppNavigationController;
import com.dlgdev.xcom2tools.R;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CharacterPlannerActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {
	@Bind(R.id.drawer_layout) DrawerLayout drawer;
	@Bind(R.id.toolbar) Toolbar toolbar;
	@Bind(R.id.nav_view) NavigationView navigationView;

	@Inject AppNavigationController appNavigation;

	public static Intent intentFor(Context context) {
		return new Intent(context, CharacterPlannerActivity.class);
	}

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character_planner);
		ButterKnife.bind(this);

		setSupportActionBar(toolbar);

		ActionBarDrawerToggle toggle =
				new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
						R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		navigationView.setNavigationItemSelectedListener(this);
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
		switch(item.getItemId()) {
			case R.id.action_settings:
				appNavigation.openSettings();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override public boolean onNavigationItemSelected(MenuItem item) {
		drawer.closeDrawer(GravityCompat.START);
		switch(item.getItemId()) {
			case R.id.nav_enemy_tracker:
				appNavigation.openEnemyTracker();
				break;
			//This 2 cases can be ignored from this point
			case R.id.nav_character_planner:
			default:
		}
		return true;
	}
}
