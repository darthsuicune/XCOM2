package com.dlgdev.xcom2tools.enemy_tracker;

import android.view.View;
import android.widget.TextView;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Alien;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AlienViewHolder extends ClickableViewHolder {

	@Bind(R.id.name) TextView name;

	public AlienViewHolder(View itemView, RecyclerItemListener listener) {
		super(itemView, listener);
		ButterKnife.bind(this, itemView);
	}

	public void setAlien(Alien alien) {
		name.setText(alien.name());
	}
}
