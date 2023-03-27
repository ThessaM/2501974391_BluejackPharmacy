package com.example.a2501974391_mcs_lab_assg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2501974391_mcs_lab_assg.item.DataSingleton;
import com.example.a2501974391_mcs_lab_assg.item.Medicine;
import com.example.a2501974391_mcs_lab_assg.item.MedicineTransaction;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class detail_page extends AppCompatActivity implements View.OnClickListener {

    EditText medicineQuantity;
    Button buyBtn;
    TextView medicineName, medicineManufacturer, medicinePrice, medicineDescription;
    ImageView medicineImage;

    Integer curUserId, curMedicineId;
    Medicine curMedDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        //get passed data
        curUserId = getIntent().getIntExtra("curUserId", 0);
        curMedicineId = getIntent().getIntExtra("curMedicineId",0);

        curMedDetail = DataSingleton.getInstance().getMedicineList().elementAt(curMedicineId);

        //action bar
        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back button
        getSupportActionBar().setIcon(R.drawable.baseline_medication_24);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //buy button
        medicineQuantity = findViewById(R.id.detail_Edtx_medicineQty);
        buyBtn = findViewById(R.id.detail_btn_buy);

        buyBtn.setOnClickListener(this);

        //set text di page -- nama, manufacture, harga, desc
        medicineName = findViewById(R.id.detail_medicineName);
        medicineManufacturer = findViewById(R.id.detail_medicineManufacturer);
        medicinePrice = findViewById(R.id.detail_medicinePrice);
        medicineDescription = findViewById(R.id.detail_medicineDescription);
        medicineImage = findViewById(R.id.detail_medicineImage);

        medicineName.setText(curMedDetail.getMedicineName());
        medicineManufacturer.setText(curMedDetail.getMedicineManufacture());
//        medicinePrice.setText(String.format(this.getResources().getString(R.string.price_symbol), curMedDetail.getMedicinePrice()));
        medicinePrice.setText(NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format((double) curMedDetail.getMedicinePrice()));
        medicineDescription.setText(curMedDetail.getMedicineDescription());
        medicineImage.setImageResource(curMedDetail.getMedicineImage());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }

//        switch (item.getItemId()){
//            case R.id.menu_logout:
//                Intent toLoginPg = new Intent(this, MainActivity.class);
//                startActivity(toLoginPg);
//                return true;
//            case R.id.menu_about:
//                Intent toAboutPg = new Intent(this, aboutus_page.class);
//                startActivity(toAboutPg);
//                return true;
//            case android.R.id.home:
//                this.finish();
//                return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(medicineQuantity.getText().toString().isEmpty()){
            Toast.makeText(this, "Quantity must be filled", Toast.LENGTH_SHORT).show();
        }else if(medicineQuantity.getText().toString().equals("0")){
            Toast.makeText(this, "Quantity must be more than 0", Toast.LENGTH_SHORT).show();
        }else{
            //masukin ke database, perlu userid sama medicineid ato nama & price
            int transIdNew;
            if(DataSingleton.getInstance().getMedTransactionList().isEmpty()){ //biar ga error kalo list empty
                transIdNew = 0;
            }else{
                transIdNew = DataSingleton.getInstance().getMedTransactionList().lastElement().getTransactionId() +1;
            }
//            java.text.DateFormat dateFormat = android.text.format.DateFormat.format("dd-MM-yyyy", java.text.DateFormat);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String curDate = dateFormat.format(new Date());
            MedicineTransaction addMedTrans = new MedicineTransaction(transIdNew, curMedicineId, curUserId, curDate, Integer.parseInt(medicineQuantity.getText().toString()));
            //bisa digabung si, kalo ada waktu
            DataSingleton.getInstance().addMedTransactionList(addMedTrans);
            DataSingleton.getInstance().addUserMedTransaction(addMedTrans);
            Toast.makeText(this, "Transaction Success", Toast.LENGTH_SHORT).show();


            //back to home page
//            Intent toHomePg = new Intent(this, home_page.class);
//            toHomePg.putExtra("curUserId", curUserId);
//            startActivity(toHomePg);

//            notifyAll();
//            this.finish();
            finish();
        }
    }
}