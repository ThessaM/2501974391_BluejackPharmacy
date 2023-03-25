package com.example.a2501974391_mcs_lab_assg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2501974391_mcs_lab_assg.item.DataSingleton;
import com.example.a2501974391_mcs_lab_assg.item.User;

import kotlin.text.Regex;

public class register_page extends AppCompatActivity implements View.OnClickListener {

    EditText nameEdtx, emailEdtx, passwordEdtx, confPasswordEdtx, phoneEdtx;
    Button registerBtn, toLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        nameEdtx = findViewById(R.id.register_edtx_name);
        emailEdtx = findViewById(R.id.register_edtx_email);
        passwordEdtx = findViewById(R.id.register_edtx_password);
        confPasswordEdtx = findViewById(R.id.register_edtx_confpassword);
        phoneEdtx = findViewById(R.id.register_edtx_phone);
        registerBtn = findViewById(R.id.register_button_register);
        toLoginBtn = findViewById(R.id.register_button_toLogin);

        registerBtn.setOnClickListener(this);
        toLoginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == registerBtn){
             if(nameEdtx.getText().toString().isEmpty() || emailEdtx.getText().toString().isEmpty() || passwordEdtx.getText().toString().isEmpty() || confPasswordEdtx.getText().toString().isEmpty() || phoneEdtx.getText().toString().isEmpty()){
                 Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
             }else if(nameEdtx.getText().toString().length() < 5){
                 Toast.makeText(this, "Name must be at least 5 characters", Toast.LENGTH_SHORT).show();
             }else if(emailEdtx.getText().toString().endsWith(".com") == false){
                 Toast.makeText(this, "Email must ends with '.com'", Toast.LENGTH_SHORT).show();
             }else if(passwordEdtx.getText().toString().matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$") == false){
                 Toast.makeText(this, "Password must be alphanumeric", Toast.LENGTH_SHORT).show();
             }else if(passwordEdtx.getText().toString().contentEquals(confPasswordEdtx.getText().toString()) == false){
                 Toast.makeText(this, "Password and confirm password must be the same", Toast.LENGTH_SHORT).show();
             }else{
                 //generate user id (integer that always increments)
                 int userNewId = DataSingleton.getInstance().getUserList().lastElement().getUserId() + 1;
                 //add data to database
                 User registerUser = new User(userNewId, nameEdtx.getText().toString(), emailEdtx.getText().toString(), passwordEdtx.getText().toString(), phoneEdtx.getText().toString(), "true");
                 DataSingleton.getInstance().addUserList(registerUser);

                 Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();

                 //back to login page
                 Intent toLoginPg = new Intent(this, MainActivity.class);
                 startActivity(toLoginPg);
                 //Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
             }

        }else if(v == toLoginBtn){
            Intent toLoginPg = new Intent(this, MainActivity.class);
            startActivity(toLoginPg);
        }
    }
}