package com.health.medicare.emedicare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class DoctorListActivity extends AppCompatActivity {
    ListView doctorListView;
    private List<Doctor> doctorList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.doctors_list);
        doctorListView = (ListView) findViewById(R.id.doctorRecyclerView);

        String categoryName=getIntent().getStringExtra("categoryName");
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        doctorList = databaseHandler.getAllDoctors(categoryName);
        //pass the list of medicines returned from db to adapter
        DoctorAdapter doctorAdapter = new DoctorAdapter(this, R.layout.doctor_row_layout, doctorList);
        doctorListView.setAdapter(doctorAdapter);

    }
}
