package com.health.medicare.emedicare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.health.medicare.emedicare.R.string.cart;

/**
 * Created by M1035979 on 2/24/2018.
 */

public class SelectMedicineActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView medicineListView;
    private TextView itemsTotalTextView;
    List<Medicine> medicineList;
    private float totalOrderPrice;
    private List<CartDetails> cartDetailsList = new ArrayList<>();
    private ArrayList<CartDetails> cartitems=new ArrayList<>();
    final EventBus mEventBus = EventBus.getDefault();
    Button continueButtton;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_medicine);
        // mEventBus.register(this);
        medicineListView = (RecyclerView) findViewById(R.id.medicineDetailsListView);
        itemsTotalTextView = (TextView) findViewById(R.id.items_total_price_textview);
        continueButtton = (Button) findViewById(R.id.continue_button);

        String categoryName = getIntent().getStringExtra("categoryName");

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        medicineList = databaseHandler.getAllMedicines(categoryName);
        //pass the list of medicines returned from db to adapter
        MedicineListAdapter medicineListAdapter = new MedicineListAdapter(this, R.layout.row_medicine_list, medicineList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SelectMedicineActivity.this);
        medicineListView.setLayoutManager(mLayoutManager);
        medicineListView.setItemAnimator(new DefaultItemAnimator());
        medicineListView.setAdapter(medicineListAdapter);
        continueButtton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_button:
                Intent intent = new Intent(this, PlaceOrderActivity.class);
                //cartitems.addAll(cartDetailsList);
                cartitems=(ArrayList<CartDetails>) cartDetailsList;
                intent.putExtra("CartDetailsList",cartitems);
                startActivity(intent);
                break;
        }
    }

    @Subscribe
    public void onEventMainThread(final Object object) {

        if (object instanceof List<?>) {
            cartDetailsList = (List<CartDetails>) object;

            itemsTotalTextView.setText("" + cartDetailsList.get(cartDetailsList.size() - 1).getTotalPrice());
            if(cartDetailsList.size()>0)
            {
                continueButtton.setEnabled(true);
            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
