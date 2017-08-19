package com.example.paulapariselias.stressless.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paulapariselias.stressless.R;
import com.example.paulapariselias.stressless.adapters.PendingClickListener;
import com.example.paulapariselias.stressless.adapters.PendingsAdapter;
import com.example.paulapariselias.stressless.models.Pending;
import com.example.paulapariselias.stressless.views.details.DetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class PendingsFragment extends Fragment implements PendingClickListener {

    public  static final String PENDING_ID = "com.example.paulapariselias.stressless.views.KEY.PENDING_ID";

    private PendingsAdapter adapter;

    public PendingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.pendingRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        adapter = new PendingsAdapter(this);
        recyclerView.setAdapter(adapter);


    }


    public void updateList(Pending pending) {
        adapter.update(pending);

        Log.d("pending", pending.getName());

    }

    @Override
    public void clickedID(long id) {


        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra(PENDING_ID,id);
        startActivity(intent);
    }
}
