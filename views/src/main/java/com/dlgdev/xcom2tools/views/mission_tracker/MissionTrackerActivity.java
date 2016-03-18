package com.dlgdev.xcom2tools.views.mission_tracker;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
	@Bind(R.id.toolbar) Toolbar toolbar;

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
		rosterView.setHasFixedSize(true);
		rosterAdapter = new RosterAdapter(roster, new RosterViewHolder.RosterClickCallback() {
			@Override public void onEnemyNameSelected(Enemy enemy) {
				onEnemyClicked(enemy);
			}
		});
		rosterView.setAdapter(rosterAdapter);

		killedEnemiesView.setLayoutManager(new LinearLayoutManager(this));
		killedEnemiesAdapter = new KilledEnemiesAdapter(killedEnemies);
		killedEnemiesView.setAdapter(killedEnemiesAdapter);
	}

	private void showEnemiesLeft() {
		enemyCount.setText(getString(R.string.enemy_counter, roster.amount()));
	}

	private void onEnemyClicked(Enemy enemy) {
		roster.killEnemy(enemy);
		killedEnemies.add(enemy);
		rosterAdapter.updateRoster(roster);
		killedEnemiesAdapter.update(killedEnemies);
		//		RosterViewHolder vh =
		//				(RosterViewHolder) rosterView.findViewHolderForAdapterPosition(position);
		//		RosterViewHolder vh1 =
		//				(RosterViewHolder) rosterView.findViewHolderForLayoutPosition(position);
		//		vh.markAsKilled();
		showEnemiesLeft();
	}

	// Added in case the user wants to undo a mistake.
	private void reviveEnemy(Enemy enemy) {
		roster.addEnemy(enemy);
		roster.setAmount(roster.amount() + 1);
		killedEnemies.remove(enemy);
		killedEnemiesAdapter.update(killedEnemies);
//		if (!killedEnemies.contains(enemy)) {
//			((RosterViewHolder) rosterView.findViewHolderForLayoutPosition(position))
//					.markAsRevived();
//		}
		showEnemiesLeft();
	}

	@Override protected int requestLayout() {
		return R.layout.activity_mission_tracker;
	}

	private class KilledEnemiesAdapter extends RecyclerView.Adapter<RosterViewHolder> {

		private List<Enemy> enemies;

		KilledEnemiesAdapter(List<Enemy> enemies) {
			this.enemies = enemies;
		}

		@Override public RosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View v = LayoutInflater.from(parent.getContext())
					.inflate(R.layout.view_holder_enemy, parent, false);
			return new RosterViewHolder(v);
		}

		@Override public void onBindViewHolder(final RosterViewHolder holder, int position) {
			holder.setEnemy(enemies.get(position), new RosterViewHolder.RosterClickCallback() {
				@Override public void onEnemyNameSelected(Enemy enemy) {
					reviveEnemy(enemy);
				}
			});
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
