package com.example.a2501974391_mcs_lab_assg.item;

import java.util.Date;

public class MedicineTransaction {

//    private Date transactionDate;
    private Integer transactionId;
    private Integer medicineId;
    private Integer userId;
    private String transactionDate;
//    private String transactionMedName;
//    private Integer transactionMedPrice;
    private Integer transactionQty;



    public MedicineTransaction(Integer transactionId, Integer medicineId, Integer userId, String transactionDate, Integer transactionQty) {
        this.transactionId = transactionId;
        this.medicineId = medicineId;
        this.userId = userId;
        this.transactionDate = transactionDate;
        this.transactionQty = transactionQty;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
    public Integer getTransactionQty() {
        return transactionQty;
    }

    public void setTransactionQty(Integer transactionQty) {
        this.transactionQty = transactionQty;
    }

}
