package com.example.a2501974391_mcs_lab_assg.item;

import java.util.Vector;

public class DataSingleton {

    //vector : sycnhronised, arraylist: nope

    private Vector<User> userList = new Vector<>();
    private Vector<Medicine> medicineList = new Vector<>();
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
