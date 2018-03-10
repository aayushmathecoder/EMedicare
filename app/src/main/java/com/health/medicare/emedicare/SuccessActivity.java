package com.health.medicare.emedicare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SuccessActivity extends AppCompatActivity {
    ListView orderPlacedList;
    private List<CartDetails> cartDetailsLst = new ArrayList<>();
    TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_actvty);
        orderPlacedList = (ListView) findViewById(R.id.orderDetailsRecyclerView);
        totalPrice = (TextView) findViewById(R.id.priceTextVew);
        cartDetailsLst = (ArrayList<CartDetails>) getIntent().getSerializableExtra("CartDetailsList");

        totalPrice.setText("Total Price " + cartDetailsLst.get(cartDetailsLst.size() - 1).getTotalPrice());
        SuccessAdapter successAdapter = new SuccessAdapter(this, R.layout.row_success_layout, cartDetailsLst);
        orderPlacedList.setAdapter(successAdapter);
    }
}
