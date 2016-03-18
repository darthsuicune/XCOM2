package com.dlgdev.xcom2tools.views.enemies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Enemy;

public class RosterViewHolder extends RecyclerView.ViewHolder {

	final TextView name;

	public RosterViewHolder(View itemView) {
		super(itemView);
		name = (TextView) itemView.findViewById(R.id.name);
	}

	public void setEnemy(final Enemy enemy, final RosterClickCallback callback) {
		name.setText(enemy.nameResId());
		name.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				callback.onEnemyNameSelected(enemy);
			}
		});
	}

	public interface RosterClickCallback {
		void onEnemyNameSelected(Enemy enemy);
	}
}
