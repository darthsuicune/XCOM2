package com.dlgdev.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ClickableViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
	int position = -1;
	public RecyclerItemListener listener;

	public ClickableViewHolder(View itemView, RecyclerItemListener listener) {
		super(itemView);
		this.listener = listener;
	}

	@Override public void onClick(View view) {
		if (position == -1) {
			throw new IllegalStateException(
					"You need to call \"setPosition\" to get click callbacks");
		}
		listener.onItemSelected(position);
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public interface RecyclerItemListener {
		void onItemSelected(int position);
	}
}
