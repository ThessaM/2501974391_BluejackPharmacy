package com.example.a2501974391_mcs_lab_assg.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2501974391_mcs_lab_assg.detail_page;
import com.example.a2501974391_mcs_lab_assg.item.Medicine;
import com.example.a2501974391_mcs_lab_assg.R;

import java.util.Vector;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {
    Context ctx;
    Vector<Medicine> medicines;

    Integer curUserId;

    public MedicineAdapter(Context ctx,  Integer curUserId) {
        this.ctx = ctx;
        this.curUserId = curUserId;
    }

    public void setMedicines(Vector<Medicine> medicines) {
        this.medicines = medicines;
    }

    @NonNull
    @Override
    public MedicineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLists = LayoutInflater.from(ctx).inflate(R.layout.medicine_item, parent, false);
        return new ViewHolder(viewLists);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineAdapter.ViewHolder holder, int position) {
//        holder.medicineImage.setImageDrawable();
        holder.medicineImage.setImageResource(medicines.get(position).getMedicineImage());
        holder.medicineName.setText(medicines.get(position).getMedicineName());
        holder.medicineManufacturer.setText(medicines.get(position).getMedicineManufacture());
//        holder.medicinePrice.setText("Rp. " + medicines.get(position).getMedicinePrice());
        holder.medicinePrice.setText(String.format(ctx.getResources().getString(R.string.price_symbol), medicines.get(position).getMedicinePrice()));
    }


    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView medicineImage;
        TextView medicineName, medicineManufacturer, medicinePrice;
        CardView medicineCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            medicineImage = itemView.findViewById(R.id.medItem_image);
            medicineName = itemView.findViewById(R.id.medItem_name);
            medicineManufacturer = itemView.findViewById(R.id.medItem_manufacturer);
            medicinePrice = itemView.findViewById(R.id.medItem_price);
            medicineCard = itemView.findViewById(R.id.medItem_cardDetails);

            medicineCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent toDetailPg = new Intent(v.getContext(), detail_page.class);
            toDetailPg.putExtra("curMedicineId", medicines.get(getAdapterPosition()).getMedicineId());
            toDetailPg.putExtra("curUserId", curUserId);
            ctx.startActivity(toDetailPg);
        }
    }

}
