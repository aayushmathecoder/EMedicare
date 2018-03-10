package com.health.medicare.emedicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SelectMedicineCategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
ListView categoryRecyclerView;
    List<Category> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_medicine);
        categoryRecyclerView=(ListView) findViewById(R.id.categoryRecyclerView);


         categoryList=new ArrayList<>();
        Category category=new Category(R.drawable.fever,"Fever");
        Category category2=new Category(R.drawable.coldcough,"Cold and Cough");
        Category category3=new Category(R.drawable.new_heart,"Heart Disease");
        Category category4=new Category(R.drawable.thyroid,"Thyroid");
        Category category5=new Category(R.drawable.general,"Senior Care");
        Category category6=new Category(R.drawable.diabete,"Diabetes");
        Category category7=new Category(R.drawable.bloodpressre,"Blood Pressure");
        Category category8=new Category(R.drawable.generalmed,"General Medicines");
        categoryList.add(category);
        categoryList.add(category2);
        categoryList.add(category3);
        categoryList.add(category4);
        categoryList.add(category5);
        categoryList.add(category6);
        categoryList.add(category7);
        categoryList.add(category8);
        //creating the adapter
        SelectMedicineAdapter adapter = new SelectMedicineAdapter(this, R.layout.row_category_layout, categoryList);

        //attaching adapter to the listview
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        categoryRecyclerView.setOnItemClickListener(this);
        //prepopulateMedicines();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent intent=new Intent(this,SelectMedicineActivity.class);
        intent.putExtra("categoryName",categoryList.get(position).getName());
        startActivity(intent);
    }
}
