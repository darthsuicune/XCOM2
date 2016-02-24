package com.dlgdev.xcom2tools.enemy_tracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.BadGuysRoster;

public class RosterAdapter extends RecyclerView.Adapter<RosterViewHolder> {
	private final BadGuysRoster roster;
	private final LayoutInflater layoutInflater;
	private final ClickableViewHolder.RecyclerItemListener listener;

	public RosterAdapter(BadGuysRoster roster, LayoutInflater layoutInflater,
						 ClickableViewHolder.RecyclerItemListener listener) {
		this.roster = roster;
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
		holder.setEnemy(position, roster.getEnemy(position));
	}

	@Override public int getItemCount() {
		return roster.enemyRoster().size();
	}
}
