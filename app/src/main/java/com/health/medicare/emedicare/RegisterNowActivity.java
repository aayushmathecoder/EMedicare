package com.health.medicare.emedicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterNowActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mobileNumberEditText;
    EditText userNameEditText;
    EditText emailEditText;
    EditText addressEditText;

    Button registerNowButton;
    private EditText passwordEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_now);
        mobileNumberEditText = (EditText) findViewById(R.id.mobile_number_edittext);
        addressEditText = (EditText) findViewById(R.id.address_edittext);
        emailEditText = (EditText) findViewById(R.id.email_edittext);
        userNameEditText = (EditText) findViewById(R.id.username_edittext);
        passwordEdittext = (EditText) findViewById(R.id.password_edittext1);
        registerNowButton = (Button) findViewById(R.id.register_now_button);
        registerNowButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_now_button:

                if ((!mobileNumberEditText.getText().toString().isEmpty()) &&
                        (!userNameEditText.getText().toString().isEmpty()) &&
                        (!addressEditText.getText().toString().isEmpty()) &&
                        (!passwordEdittext.getText().toString().isEmpty()) &&
                        (!emailEditText.getText().toString().isEmpty())) {
                    UserDetails userDetails = new UserDetails(userNameEditText.getText().toString(), mobileNumberEditText.getText().toString(), emailEditText.getText().toString(), addressEditText.getText().toString(), passwordEdittext.getText().toString());
                    DatabaseHandler databaseHandler = new DatabaseHandler(this);
                    databaseHandler.addUserDetails(userDetails);
                    Toast.makeText(this, "You have successfully registered!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(this, "All the fields are mandatory", Toast.LENGTH_LONG).show();
                }
                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
