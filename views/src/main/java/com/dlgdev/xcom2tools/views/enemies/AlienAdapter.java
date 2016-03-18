package com.dlgdev.xcom2tools.views.enemies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;

import java.util.List;

public class AlienAdapter extends RecyclerView.Adapter<AlienViewHolder> {
	List<Alien> aliens;
	private AlienViewHolder.AlienClickCallbacks callback;

	public AlienAdapter(List<Alien> aliens, AlienViewHolder.AlienClickCallbacks callback) {
		this.aliens = aliens;
		this.callback = callback;
	}

	@Override public AlienViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.view_holder_alien, parent, false);
		return new AlienViewHolder(v);
	}

	@Override public void onBindViewHolder(AlienViewHolder holder, int position) {
		holder.setAlien(aliens.get(position), callback);
	}

	@Override public int getItemCount() {
		return aliens.size();
	}
}