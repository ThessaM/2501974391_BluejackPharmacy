package com.example.a2501974391_mcs_lab_assg.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2501974391_mcs_lab_assg.R;
import com.example.a2501974391_mcs_lab_assg.home_page;
import com.example.a2501974391_mcs_lab_assg.item.DataSingleton;
import com.example.a2501974391_mcs_lab_assg.item.Medicine;
import com.example.a2501974391_mcs_lab_assg.item.MedicineTransaction;

import java.util.Vector;

public class MedTransactionAdapter extends RecyclerView.Adapter<MedTransactionAdapter.ViewHolder> {

    Context ctx;
    Vector<MedicineTransaction> medicineTransactions;
    Vector<Medicine> medicines;

    public MedTransactionAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setMedicineTransactions(Vector<MedicineTransaction> medicineTransactions) {
        this.medicineTransactions = medicineTransactions;
        this.medicines = DataSingleton.getInstance().getMedicineList();
    }


    @NonNull
    @Override
    public MedTransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewTransactions = LayoutInflater.from(ctx).inflate(R.layout.transaction_med_item, parent, false);
        return new ViewHolder(viewTransactions);
    }

    @Override
    public void onBindViewHolder(@NonNull MedTransactionAdapter.ViewHolder holder, int position) {
        //kalo isi bisa berubah direkomen pake getAdapterPosition(?)
        holder.transaction_date.setText(medicineTransactions.get(holder.getAdapterPosition()).getTransactionDate());
        holder.transaction_medName.setText(medicines.get(medicineTransactions.get(holder.getAdapterPosition()).getMedicineId()).getMedicineName());
        holder.transaction_medPrice.setText(String.format(ctx.getResources().getString(R.string.price_symbol), medicines.get(medicineTransactions.get(holder.getAdapterPosition()).getMedicineId()).getMedicinePrice()));
        holder.transaction_qty.setText(String.format(ctx.getResources().getString(R.string.quantityDisplay), medicineTransactions.get(holder.getAdapterPosition()).getTransactionQty()));
    }

    @Override
    public int getItemCount() {
        return medicineTransactions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView transaction_date, transaction_medName, transaction_medPrice, transaction_qty;

        ImageButton updateBtn, deleteBtn;
        Button cancelBtn, confirmBtn;
        EditText quantityNew;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transaction_date = itemView.findViewById(R.id.transItem_date);
            transaction_medName = itemView.findViewById(R.id.transItem_medName);
            transaction_medPrice = itemView.findViewById(R.id.transItem_medPrice);
            transaction_qty = itemView.findViewById(R.id.transItem_qty);

            //card buttons -- onclick
            updateBtn = itemView.findViewById(R.id.transMed_updateBtn);
            deleteBtn = itemView.findViewById(R.id.transMed_deleteBtn);
            updateBtn.setOnClickListener(this);
            deleteBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v == updateBtn){
                showEditQtyDialog(v.getContext());
            }else if(v == deleteBtn){
                MedicineTransaction curTransId = medicineTransactions.get(getAdapterPosition());
//                Vector<MedicineTransaction> deletedTransList = DataSingleton.getInstance().getMedTransactionList();
//                deletedTransList.remove(curTransId);
//                DataSingleton.getInstance().setMedTransactionList(deletedTransList);
                DataSingleton.getInstance().deleteMedTransactionList(curTransId);
                DataSingleton.getInstance().deleteUserMedTransaction(curTransId);
                notifyItemRemoved(getAdapterPosition());
//                notifyDataSetChanged();
                Toast.makeText(v.getContext(), "delete success", Toast.LENGTH_SHORT).show();

            }
        }

        private void showEditQtyDialog(Context context) {
            final Dialog qtyDialog = new Dialog(context);
            qtyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            qtyDialog.setCancelable(true);
            qtyDialog.setContentView(R.layout.dialog_update_quantity);
            qtyDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            qtyDialog.show();

            //dialog buttons
            cancelBtn = qtyDialog.findViewById(R.id.dialog_Btn_cancel);
            confirmBtn = qtyDialog.findViewById(R.id.dialog_Btn_confirm);
            quantityNew = qtyDialog.findViewById(R.id.dialog_edtx_newQty);

            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qtyDialog.dismiss();
                }
            });
//
            confirmBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(quantityNew.getText().toString().isEmpty()){
                        Toast.makeText(v.getContext(), "Quantity must be filled", Toast.LENGTH_SHORT).show();
                    } else if(Integer.parseInt(quantityNew.getText().toString()) == 0){
                        Toast.makeText(v.getContext(), "Quantity must be more than 0", Toast.LENGTH_SHORT).show();
                    }else{
                        MedicineTransaction curTransId = medicineTransactions.get(getAdapterPosition());
                        int mainTransactionIdx = DataSingleton.getInstance().getMedTransactionList().indexOf(curTransId);
                        curTransId.setTransactionQty(Integer.parseInt(quantityNew.getText().toString()));
                        DataSingleton.getInstance().updateTransactionList(curTransId, mainTransactionIdx);
                        DataSingleton.getInstance().updateUserMedTransaction(curTransId, getAdapterPosition());
                        notifyItemChanged(getAdapterPosition());
                        qtyDialog.dismiss();
                        Toast.makeText(v.getContext(), "update success", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
