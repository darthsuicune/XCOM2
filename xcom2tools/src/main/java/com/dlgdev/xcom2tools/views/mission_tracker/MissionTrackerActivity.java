package com.dlgdev.xcom2tools.views.mission_tracker;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.BadGuysRoster;
import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;
import com.dlgdev.xcom2tools.views.AppNavigationController;
import com.dlgdev.xcom2tools.views.NavigationActivity;
import com.dlgdev.xcom2tools.views.dagger.DaggerMissionTrackerComponent;
import com.dlgdev.xcom2tools.views.dagger.MissionTrackerModule;
import com.dlgdev.xcom2tools.views.enemies.RosterAdapter;
import com.dlgdev.xcom2tools.views.enemies.RosterViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MissionTrackerActivity extends NavigationActivity {

	public static final String EXTRA_ROSTER = "roster";

	@Bind(R.id.enemy_count) TextView enemyCount;
	@Bind(R.id.roster) RecyclerView rosterView;
	@Bind(R.id.killed_enemies) RecyclerView killedEnemiesView;

	@Inject AppNavigationController appNavigation;
	@Inject BadGuysRoster roster;
	List<Enemy> killedEnemies = new ArrayList<>();

	RosterAdapter rosterAdapter;
	KilledEnemiesAdapter killedEnemiesAdapter;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DaggerMissionTrackerComponent.builder().missionTrackerModule(new MissionTrackerModule(this))
				.build().inject(this);
		Bundle extras = getIntent().getExtras();
		if (extras.containsKey(EXTRA_ROSTER)) {
			roster.updateFromBundle(extras.getBundle(EXTRA_ROSTER));
		}
		setupViews();
	}

	private void setupViews() {
		showEnemiesLeft();
		rosterView.setLayoutManager(new LinearLayoutManager(this));
		rosterAdapter = new RosterAdapter(roster, getLayoutInflater(),
				new ClickableViewHolder.RecyclerItemListener() {
					@Override public void onItemSelected(int position) {
						onEnemyClicked(position);
					}
				});
		rosterView.setAdapter(rosterAdapter);

		killedEnemiesView.setLayoutManager(new LinearLayoutManager(this));
		killedEnemiesAdapter = new KilledEnemiesAdapter(killedEnemies, getLayoutInflater(),
				new ClickableViewHolder.RecyclerItemListener() {
					@Override public void onItemSelected(int position) {
						reviveEnemy(position);
					}
				});
		killedEnemiesView.setAdapter(killedEnemiesAdapter);
	}

	private void showEnemiesLeft() {
		enemyCount.setText(getString(R.string.enemy_counter, roster.amount()));
	}

	private void onEnemyClicked(int position) {
		Enemy enemy = roster.getEnemy(position);
		roster.killEnemy(enemy);
		killedEnemies.add(enemy);
		RosterViewHolder vh =
				(RosterViewHolder) rosterView.findViewHolderForAdapterPosition(position);
		RosterViewHolder vh1 =
				(RosterViewHolder) rosterView.findViewHolderForLayoutPosition(position);
		vh.markAsKilled();
		rosterAdapter.updateRoster(roster);
		killedEnemiesAdapter.update(killedEnemies);
		showEnemiesLeft();
	}

	//This in theory should only happen if the user messes up.
	private void reviveEnemy(int position) {
		Enemy enemy = killedEnemies.get(position);
		roster.addEnemy(enemy);
		roster.setAmount(roster.amount() + 1);
		showEnemiesLeft();
		killedEnemies.remove(position);
		killedEnemiesAdapter.update(killedEnemies);
		if (!killedEnemies.contains(enemy)) {
			((RosterViewHolder) rosterView.findViewHolderForLayoutPosition(position))
					.markAsRevived();
		}
	}

	@Override protected int requestLayout() {
		return R.layout.activity_mission_tracker;
	}

	private class KilledEnemiesAdapter extends RecyclerView.Adapter<RosterViewHolder> {

		private List<Enemy> enemies;
		private final LayoutInflater layoutInflater;
		ClickableViewHolder.RecyclerItemListener listener;

		KilledEnemiesAdapter(List<Enemy> enemies, LayoutInflater layoutInflater,
							 ClickableViewHolder.RecyclerItemListener listener) {
			this.enemies = enemies;
			this.layoutInflater = layoutInflater;
			this.listener = listener;
		}

		@Override public RosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View v = layoutInflater.inflate(R.layout.view_holder_enemy, parent, false);
			RosterViewHolder vh = new RosterViewHolder(v, listener);
			v.setOnClickListener(vh);
			return vh;
		}

		@Override public void onBindViewHolder(RosterViewHolder holder, int position) {
			holder.setEnemy(position, enemies.get(position));
		}

		@Override public int getItemCount() {
			return enemies.size();
		}

		public void update(List<Enemy> enemies) {
			this.enemies = enemies;
			notifyDataSetChanged();
		}
	}
}
