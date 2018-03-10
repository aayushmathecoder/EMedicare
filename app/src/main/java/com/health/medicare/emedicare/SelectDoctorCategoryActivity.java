package com.health.medicare.emedicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SelectDoctorCategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView doctorcategoryRecyclerView;
    private ArrayList<Category> doctorcategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor_category);

        doctorcategoryRecyclerView = (ListView) findViewById(R.id.doctorCategoryRecyclerView);


        doctorcategoryList = new ArrayList<>();
        Category category = new Category(R.drawable.eye, "Opthalmologist");
        Category category2 = new Category(R.drawable.spray, "Dermatologist");
        Category category3 = new Category(R.drawable.generalmed, "General Physician");
        Category category4 = new Category(R.drawable.coldcough, "ENT Specialist");
        Category category5 = new Category(R.drawable.dentist, "Dentist");
        Category category6 = new Category(R.drawable.generalmed, "Orthopodist");
        Category category7 = new Category(R.drawable.doctor, "Neurologist");
        Category category8 = new Category(R.drawable.urologist, "Urologist");
        doctorcategoryList.add(category);
        doctorcategoryList.add(category2);
        doctorcategoryList.add(category3);
        doctorcategoryList.add(category4);
        doctorcategoryList.add(category5);
        doctorcategoryList.add(category6);
        doctorcategoryList.add(category7);
        doctorcategoryList.add(category8);
        //creating the adapter
        SelectMedicineAdapter adapter = new SelectMedicineAdapter(this, R.layout.row_category_layout, doctorcategoryList);

        //attaching adapter to the listview
        doctorcategoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        doctorcategoryRecyclerView.setOnItemClickListener(this);
        //prepopulateMedicines();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent intent = new Intent(this, DoctorListActivity.class);
        intent.putExtra("categoryName", doctorcategoryList.get(position).getName());
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}


