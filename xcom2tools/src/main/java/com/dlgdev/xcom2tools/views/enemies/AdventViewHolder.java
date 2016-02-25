package com.dlgdev.xcom2tools.views.enemies;

import android.view.View;
import android.widget.TextView;

import com.dlgdev.views.ClickableViewHolder;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.domain.characters.badguys.Advent;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AdventViewHolder extends ClickableViewHolder {

	@Bind(R.id.name) TextView name;

	public AdventViewHolder(View itemView, RecyclerItemListener listener) {
		super(itemView, listener);
		ButterKnife.bind(this, itemView);
	}

	public void setAdvent(int position, Advent advent) {
		setPosition(position);
		name.setText(advent.nameResId());
	}
}
