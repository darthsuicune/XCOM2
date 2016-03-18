package com.dlgdev.xcom2tools.views.enemies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.BadGuysRoster;

public class RosterAdapter extends RecyclerView.Adapter<RosterViewHolder> {
	BadGuysRoster roster;
	private RosterViewHolder.RosterClickCallback callback;

	public RosterAdapter(BadGuysRoster roster, RosterViewHolder.RosterClickCallback callback) {
		this.roster = roster;
		this.callback = callback;
	}

	@Override public RosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.view_holder_enemy, parent, false);
		return new RosterViewHolder(v);
	}

	@Override public void onBindViewHolder(final RosterViewHolder holder, int position) {
		holder.setEnemy(roster.getEnemy(position), callback);
	}

	@Override public int getItemCount() {
		return roster.enemyRoster().size();
	}

	public void updateRoster(BadGuysRoster roster) {
		this.roster = roster;
		notifyDataSetChanged();
	}
}
