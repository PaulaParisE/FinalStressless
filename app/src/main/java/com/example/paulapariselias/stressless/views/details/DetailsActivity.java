package com.example.paulapariselias.stressless.views.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.EditText;

import com.example.paulapariselias.stressless.R;
import com.example.paulapariselias.stressless.models.Pending;
import com.example.paulapariselias.stressless.views.main.PendingsFragment;

public class DetailsActivity extends AppCompatActivity {

    private Pending pending;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        editText= (EditText) findViewById(R.id.detailsTv);


        long idPending = getIntent().getLongExtra(PendingsFragment.PENDING_ID,0);

        pending = Pending.findById(Pending.class, idPending);
        pending.getName();


        getSupportActionBar().setTitle(pending.getName());
        editText.setText(pending.getName());



    }

    @Override
    protected void onResume() {
        super.onResume();
        if (pending.getDescription() != null){
            editText.setText(pending.getDescription());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Editable editable = editText.getText();
        pending.setDescription(String.valueOf(editable));
        pending.save();
    }
}
