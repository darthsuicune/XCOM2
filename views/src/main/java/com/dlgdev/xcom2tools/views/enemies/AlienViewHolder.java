package com.dlgdev.xcom2tools.views.enemies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AlienViewHolder extends RecyclerView.ViewHolder {

	@Bind(R.id.name) TextView name;

	public AlienViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void setAlien(final Alien alien, final AlienClickCallbacks callback) {
		name.setText(alien.nameResId());
		name.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				callback.onNameClicked(alien);
			}
		});
	}

	public interface AlienClickCallbacks {
		void onNameClicked(Alien alien);
	}
}
