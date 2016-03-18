package com.dlgdev.xcom2tools.views.enemies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;

import java.util.List;

public class AdventAdapter extends RecyclerView.Adapter<AdventViewHolder> {
	List<Advent> advents;
	private AdventViewHolder.AdventClickCallbacks callback;

	public AdventAdapter(List<Advent> advents, AdventViewHolder.AdventClickCallbacks callback) {
		this.advents = advents;
		this.callback = callback;
	}

	@Override public AdventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.view_holder_advent, parent, false);
		return new AdventViewHolder(v);
	}

	@Override public void onBindViewHolder(AdventViewHolder holder, int position) {
		holder.setAdvent(advents.get(position), callback);
	}

	@Override public int getItemCount() {
		return advents.size();
	}
}
