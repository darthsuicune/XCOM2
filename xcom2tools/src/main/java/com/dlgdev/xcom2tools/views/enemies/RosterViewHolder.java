package com.dlgdev.xcom2tools.views.enemies;

import android.view.View;
import android.widget.TextView;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RosterViewHolder extends ClickableViewHolder {

	@Bind(R.id.name) TextView name;

	public RosterViewHolder(View itemView, RecyclerItemListener listener) {
		super(itemView, listener);
		ButterKnife.bind(this, itemView);
	}

	public void setEnemy(int position, Enemy enemy) {
		setPosition(position);
		name.setText(enemy.nameResId());
	}
}
