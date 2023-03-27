package com.example.a2501974391_mcs_lab_assg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2501974391_mcs_lab_assg.item.DataSingleton;
import com.example.a2501974391_mcs_lab_assg.item.Medicine;
import com.example.a2501974391_mcs_lab_assg.item.MedicineTransaction;
import com.example.a2501974391_mcs_lab_assg.item.User;

import java.util.Vector;


//harusnya login page, tp udh terlanjur gini, gpp la ya
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailEdtx, passwordEdtx;
    Button loginBtn, toRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEdtx = findViewById(R.id.login_edtx_email);
        passwordEdtx = findViewById(R.id.login_edtx_password);
        loginBtn = findViewById(R.id.login_button_login);
        toRegisterBtn = findViewById(R.id.login_button_toRegister);

        loginBtn.setOnClickListener(this);
        toRegisterBtn.setOnClickListener(this);

        //set global variables
        if(DataSingleton.getInstance().getMedicineList().isEmpty()){
            Vector<Medicine> medicineList;
            medicineList = new Vector<>();
            medicineList.add(new Medicine(0, R.drawable.medicine_template_a, "BlueJack Med Capsule", "PT. BluejackCompany", 15000, "Medicine for stomach ache"));
            medicineList.add(new Medicine(1, R.drawable.medicine_template_b, "BlueJack Flu Pill", "PT. BluejackCompany x PT. PillPharma", 25000, "Flu Pill created by Bluejack Company and PullPharma"));
            medicineList.add(new Medicine(2, R.drawable.medicine_template_c, "BlueJack Honey Remedy", "PT. BluejackCompany", 50000, "Cough Medicine, eat 2 times a day for maximum effect"));
            DataSingleton.getInstance().setMedicineList(medicineList);
//            Toast.makeText(this, "medListDone", Toast.LENGTH_SHORT).show();
        }
//        else{
//            Toast.makeText(this, "medListskip", Toast.LENGTH_SHORT).show();
//        }

        if(DataSingleton.getInstance().getUserList().isEmpty()){
            //admin biar ga perlu register terus
            User adminUser = new User(0, "admin", "admin.com", "admin123", "08123456789", "true");
            DataSingleton.getInstance().addUserList(adminUser);
        }

        if(DataSingleton.getInstance().getMedTransactionList().isEmpty()){
            MedicineTransaction adminTrans = new MedicineTransaction(0,0,0,"20-12-2023", 4);
            DataSingleton.getInstance().addMedTransactionList(adminTrans);
        }


    }

    Boolean emailExist = false;

    @Override
    public void onClick(View v) {
        if(v == loginBtn){
            if(emailEdtx.getText().toString().isEmpty()){
                Toast.makeText(this, "Email must be filled", Toast.LENGTH_SHORT).show();
            }else if(passwordEdtx.getText().toString().isEmpty()){
                Toast.makeText(this, "Passowrd must be filled", Toast.LENGTH_SHORT).show();
            }else{
                //validate to database (username (kan yg diminta email?) + password, cek verified)
                DataSingleton.getInstance().getUserList().forEach(
                    userData -> {
                        if(userData.getUserEmail().equals(emailEdtx.getText().toString())){
                            //kalo ketemu email yg sama, cek password
                            emailExist = true;
                            if(userData.getUserPassword().equals(passwordEdtx.getText().toString())){
                                //cek verified
                                if(userData.getIsVerified().equals("true")){
                                    //semua validation terpenuhi
                                    //go to home page
                                    Intent toHomePg = new Intent(this, home_page.class);
                                    //passing userId
                                    toHomePg.putExtra("curUserId", userData.getUserId());

                                    //set usertransactionlist
                                    Vector<MedicineTransaction> userTransaction = new Vector<>();
                                    DataSingleton.getInstance().getMedTransactionList().forEach(transData->{
                                        if(transData.getUserId().equals(userData.getUserId())){
                                            userTransaction.add(transData);
                                        }
                                    });
                                    DataSingleton.getInstance().setUserMedTransaction(userTransaction);


                                    Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                                    startActivity(toHomePg);

                                }else{
                                    Toast.makeText(this, "User is Not Verified", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                //password salah
                                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                );

                if(!emailExist){
                    Toast.makeText(this, "Email is not registered", Toast.LENGTH_SHORT).show();
                }

            }
        }else if(v == toRegisterBtn){
            Intent toRegisterPg = new Intent(this, register_page.class);
            startActivity(toRegisterPg);
        }
    }
}