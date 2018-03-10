package com.health.medicare.emedicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mobileNumberEditText;
    EditText passwordEditText;
    Button signInButton;
    Button registerNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mobileNumberEditText = (EditText) findViewById(R.id.mobile_number_edittext);
        passwordEditText = (EditText) findViewById(R.id.password_edittext);
        signInButton = (Button) findViewById(R.id.sign_in_button);
        registerNowButton = (Button) findViewById(R.id.register_now_button);
        signInButton.setOnClickListener(this);
        registerNowButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                if (mobileNumberEditText.getText().toString().length() < 10) {
                    Toast.makeText(this, "Enter 10 digit Mobile Number", Toast.LENGTH_SHORT).show();
                } else if ((!mobileNumberEditText.getText().toString().isEmpty()) && (!passwordEditText.getText().toString().isEmpty())) {
                    //validate from db, if the user exists in db or not
                    DatabaseHandler databaseHandler = new DatabaseHandler(this);
                    boolean isUserExist = databaseHandler.isUserExist(mobileNumberEditText.getText().toString(), passwordEditText.getText().toString());
                    if (isUserExist) {
                        Intent intent = new Intent(this, HomeActivity.class);

                        startActivity(intent);
                        finish();
                    } else {

                        Toast.makeText(this, "User doesn't exist.Please Register Now. ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Mobile Number or Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_now_button:
                Intent intent = new Intent(this, RegisterNowActivity.class);

                startActivity(intent);
                finish();
                break;

        }
    }



}
