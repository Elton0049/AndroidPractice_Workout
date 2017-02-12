package com.practice.chaejeonghun.workoutbyelton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_WORKOUT_ID = "intent_workout_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_detail);

        workoutDetailFragment.setWorkOutId(getIntent().getIntExtra(INTENT_WORKOUT_ID, 0));
    }
}
