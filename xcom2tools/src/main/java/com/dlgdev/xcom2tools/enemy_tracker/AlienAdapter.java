package com.dlgdev.xcom2tools.enemy_tracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;

import java.util.List;

public class AlienAdapter extends RecyclerView.Adapter<AlienViewHolder> {
	List<Alien> aliens;
	private LayoutInflater inflater;
	private ClickableViewHolder.RecyclerItemListener listener;

	public AlienAdapter(List<Alien> aliens, LayoutInflater inflater,
						 ClickableViewHolder.RecyclerItemListener listener) {
		this.aliens = aliens;
		this.inflater = inflater;
		this.listener = listener;
	}

	@Override public AlienViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = inflater.inflate(R.layout.view_holder_alien, parent, false);
		AlienViewHolder holder = new AlienViewHolder(v, listener);
		v.setOnClickListener(holder);
		return holder;
	}

	@Override public void onBindViewHolder(AlienViewHolder holder, int position) {
		holder.setAlien(position, aliens.get(position));
	}

	@Override public int getItemCount() {
		return aliens.size();
	}
}