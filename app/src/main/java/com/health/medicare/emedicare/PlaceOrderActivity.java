package com.health.medicare.emedicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceOrderActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mobileNumberEditText;
    EditText emailEditText;
    EditText addressEditText;

    Button placeOrderButton;
    Button cancelOrderButton;
    float totalPrice;
    UserDetails userDetails;
    ArrayList<CartDetails> cartDetailsLst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        totalPrice = getIntent().getFloatExtra("TotalPrice", 0.0f);

        mobileNumberEditText = (EditText) findViewById(R.id.mobile_number_edittext);
        addressEditText = (EditText) findViewById(R.id.address_edittext);
        emailEditText = (EditText) findViewById(R.id.email_edittext);

        placeOrderButton = (Button) findViewById(R.id.place_order_button);
        cancelOrderButton = (Button) findViewById(R.id.cancel_order_button);
        cartDetailsLst=(ArrayList<CartDetails>) getIntent().getSerializableExtra("CartDetailsList");

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        userDetails = databaseHandler.getUserDetails();
        mobileNumberEditText.setText(userDetails.getMobileNumber());
        addressEditText.setText(userDetails.getAddress());
        emailEditText.setText(userDetails.getEmail());


        placeOrderButton.setOnClickListener(this);
        cancelOrderButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.place_order_button:

                if ((!mobileNumberEditText.getText().toString().isEmpty()) &&
                        (!addressEditText.getText().toString().isEmpty()) &&
                        (!emailEditText.getText().toString().isEmpty())) {
                    Intent intent=new Intent(this,SuccessActivity.class);
                    intent.putExtra("CartDetailsList",cartDetailsLst);
                    startActivity(intent);
                    Toast.makeText(this, "You have successfully placed your Order!", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(this, "All the fields are mandatory", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.cancel_order_button:
                finish();
                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
