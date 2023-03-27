package com.example.a2501974391_mcs_lab_assg.item;

import com.example.a2501974391_mcs_lab_assg.R;

import java.util.Arrays;
import java.util.Vector;

public class DataSingleton {

    //vector : sycnhronised, arraylist: nope

    private Vector<User> userList = new Vector<>();
    private Vector<Medicine> medicineList = new Vector<>(Arrays.asList(
            new Medicine(0, R.drawable.medicine_template_a, "BlueJack Med Capsule", "PT. BluejackCompany", 15000, "Medicine for stomach ache"),
            new Medicine(1, R.drawable.medicine_template_b, "BlueJack Flu Pill", "PT. BluejackCompany x PT. PillPharma", 25000, "Flu Pill created by Bluejack Company and PullPharma"),
            new Medicine(2, R.drawable.medicine_template_c, "BlueJack Honey Remedy", "PT. BluejackCompany", 50000, "Cough Medicine, eat 2 times a day for maximum effect")
    ));
    private Vector<MedicineTransaction> medTransactionList = new Vector<>();
    private Vector<MedicineTransaction> userMedTransaction = new Vector<>();

    //singleton
    private static DataSingleton instance;

    public static DataSingleton getInstance() {
        if(instance == null){
            instance = new DataSingleton();
        }
        return instance;
    }

    private DataSingleton(){}


    //buat edit isi vector (?)
    public Vector<User> getUserList() {
        return userList;
    }

//    public void setUserList(Vector<User> userList) {
//        this.userList = userList;
//    }

    public void addUserList(User userAdd) {
        this.userList.add(userAdd);
    }

    public Vector<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(Vector<Medicine> medicineList) {
        this.medicineList = medicineList;
    }


    //MedTransaction
    public Vector<MedicineTransaction> getMedTransactionList() {
        return medTransactionList;
    }

    public void setMedTransactionList(Vector<MedicineTransaction> medTransactionList) {
        this.medTransactionList = medTransactionList;
    }
    public void addMedTransactionList(MedicineTransaction medTransactionAdd) {
        this.medTransactionList.add(medTransactionAdd);
    }
    public void deleteMedTransactionList(MedicineTransaction medTransactionDel) {
        this.medTransactionList.remove(medTransactionDel);
    }

    public void updateTransactionList(MedicineTransaction medTransactionUpd, int index) {
        this.medTransactionList.setElementAt(medTransactionUpd, index);
    }

    //userMedTransaction
    public Vector<MedicineTransaction> getUserMedTransaction() {
        return userMedTransaction;
    }

    public void setUserMedTransaction(Vector<MedicineTransaction> userMedTransaction) {
        this.userMedTransaction = userMedTransaction;
    }

    public void addUserMedTransaction(MedicineTransaction userMedTransaction) {
        this.userMedTransaction.add(userMedTransaction);
    }

    public void deleteUserMedTransaction(MedicineTransaction userMedTransaction) {
        this.userMedTransaction.remove(userMedTransaction);
    }

    public void updateUserMedTransaction(MedicineTransaction userMedTransaction, int index) {
        this.userMedTransaction.setElementAt(userMedTransaction, index);
    }
}
