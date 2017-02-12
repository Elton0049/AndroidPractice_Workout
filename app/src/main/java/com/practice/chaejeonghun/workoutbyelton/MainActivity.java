package com.practice.chaejeonghun.workoutbyelton;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkOutListFragment.WorkOutListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onItemClicked(int position) {
        View view = findViewById(R.id.frame_container);

        // Large Screen like tablet
        if (view != null) {
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
            workoutDetailFragment.setWorkOutId(position);

            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, workoutDetailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.INTENT_WORKOUT_ID, position);
            startActivity(intent);
        }
    }
}
