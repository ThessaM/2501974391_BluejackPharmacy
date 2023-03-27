package com.example.a2501974391_mcs_lab_assg;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2501974391_mcs_lab_assg.adapter.MedicineAdapter;
import com.example.a2501974391_mcs_lab_assg.item.DataSingleton;


public class home_home extends Fragment {

    public home_home() {
        // Required empty public constructor
    }

//    View homeView;
    RecyclerView medicineReView;
//    Vector<Medicine> medicineList;
    MedicineAdapter medicineAdapter;

    Integer curUserId;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        curUserId = bundle.getInt("curUserId");

        return inflater.inflate(R.layout.fragment_home_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicineAdapter = new MedicineAdapter(view.getContext(), curUserId);
        medicineAdapter.setMedicines(DataSingleton.getInstance().getMedicineList());

        //apa salah dan dosakuuuu
        medicineReView = view.findViewById(R.id.home_home_medReView) ;
        medicineReView.setAdapter(medicineAdapter);
        medicineReView.setHasFixedSize(true);
        medicineReView.setLayoutManager(new LinearLayoutManager(view.getContext()));

    }

}