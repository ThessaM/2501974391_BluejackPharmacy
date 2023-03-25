package com.example.a2501974391_mcs_lab_assg.item;

//import android.widget.ImageView;

public class Medicine {

//    private ImageView medicineImage;
    private Integer medicineId;
    private Integer medicineImage; //jgn lupa ganti, di soal pake string (mungkin pake cara url)
    private String medicineName;
    private String medicineManufacture;
    private Integer medicinePrice;
    private String medicineDescription;

//    public Medicine(ImageView medicineImage, String medicineName, String medicineManufacture, int medicinePrice) {
//        this.medicineImage = medicineImage;
//        this.medicineName = medicineName;
//        this.medicineManufacture = medicineManufacture;
//        this.medicinePrice = medicinePrice;
//    }
public Medicine(int medicineId, int medicineImage, String medicineName, String medicineManufacture, int medicinePrice, String medicineDescription) {
    this.medicineId = medicineId;
    this.medicineImage = medicineImage;
    this.medicineName = medicineName;
    this.medicineManufacture = medicineManufacture;
    this.medicinePrice = medicinePrice;
    this.medicineDescription = medicineDescription;
}

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public int getMedicineImage() {
        return medicineImage;
    }

    public void setMedicineImage(int medicineImage) {
        this.medicineImage = medicineImage;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineManufacture() {
        return medicineManufacture;
    }

    public void setMedicineManufacture(String medicineManufacture) {
        this.medicineManufacture = medicineManufacture;
    }

    public int getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(int medicinePrice) {
        this.medicinePrice = medicinePrice;
    }


    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }


}

