package com.dlgdev.xcom2tools.views.character_planner;

import android.os.Bundle;

import com.dlgdev.xcom2tools.views.NavigationActivity;
import com.dlgdev.xcom2tools.R;
import com.dlgdev.xcom2tools.views.dagger.CharacterPlannerModule;
import com.dlgdev.xcom2tools.dagger.DaggerCharacterPlannerComponent;

public class CharacterPlannerActivity extends NavigationActivity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DaggerCharacterPlannerComponent.builder()
				.characterPlannerModule(new CharacterPlannerModule(this)).build().inject(this);
	}

	@Override protected int requestLayout() {
		return R.layout.activity_character_planner;
	}
}
