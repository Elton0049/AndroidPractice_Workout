package com.practice.chaejeonghun.workoutbyelton;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WorkoutDetailFragment extends Fragment {
    private int workoutId;
    private static final String SAVED_ID = "saved_id";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getInt(SAVED_ID);
        }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Workout workout = Workout.workouts[workoutId];
            TextView nameTextView = (TextView) view.findViewById(R.id.workout_name);
            TextView descTextView = (TextView) view.findViewById(R.id.workout_description);
            nameTextView.setText(workout.getName());
            descTextView.setText(workout.getDescription());
        }
    }

    public void setWorkOutId(int id) {
        workoutId = id;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_ID, workoutId);
    }
}
