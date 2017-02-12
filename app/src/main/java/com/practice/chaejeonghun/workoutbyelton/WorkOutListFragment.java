package com.practice.chaejeonghun.workoutbyelton;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class WorkOutListFragment extends ListFragment {
    private WorkOutListener workOutListener;

    interface WorkOutListener {
        void onItemClicked(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        workOutListener = (WorkOutListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<String> workoutNameList = new ArrayList<>();
        for (Workout w : Workout.workouts) {
            workoutNameList.add(w.getName());
        }

        ArrayAdapter<String> workoutAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, workoutNameList);
        setListAdapter(workoutAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (workOutListener != null) {
            workOutListener.onItemClicked(position);
        }
    }
}
