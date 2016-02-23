package com.dlgdev.xcom2tools.enemy_tracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;

import java.util.List;

public class AdventAdapter extends RecyclerView.Adapter<AdventViewHolder> {
	List<Advent> advents;
	private LayoutInflater inflater;
	private ClickableViewHolder.RecyclerItemListener listener;

	public AdventAdapter(List<Advent> advents, LayoutInflater inflater,
						 ClickableViewHolder.RecyclerItemListener listener) {
		this.advents = advents;
		this.inflater = inflater;
		this.listener = listener;
	}

	@Override public AdventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = inflater.inflate(R.layout.view_holder_advent, parent, false);
		AdventViewHolder holder = new AdventViewHolder(v, listener);
		v.setOnClickListener(holder);
		return holder;
	}

	@Override public void onBindViewHolder(AdventViewHolder holder, int position) {
		holder.setAdvent(advents.get(position));
	}

	@Override public int getItemCount() {
		return advents.size();
	}
}
