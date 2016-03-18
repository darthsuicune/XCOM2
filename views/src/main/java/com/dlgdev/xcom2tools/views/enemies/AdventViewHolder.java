package com.dlgdev.xcom2tools.views.enemies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AdventViewHolder extends RecyclerView.ViewHolder {

	@Bind(R.id.name) TextView name;

	public AdventViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void setAdvent(final Advent advent, final AdventClickCallbacks callback) {
		name.setText(advent.nameResId());
		name.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				callback.onNameClicked(advent);
			}
		});
	}

	public interface AdventClickCallbacks {
		void onNameClicked(Advent advent);
	}
}
