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
import android.widget.TextView;

import com.example.a2501974391_mcs_lab_assg.adapter.MedTransactionAdapter;
import com.example.a2501974391_mcs_lab_assg.item.DataSingleton;
import com.example.a2501974391_mcs_lab_assg.item.MedicineTransaction;

import java.util.Vector;


public class home_transaction extends Fragment {

    RecyclerView medicineTransactionReView;
    TextView noTransactionText;
    Vector<MedicineTransaction> medicineTransactionList;
    MedTransactionAdapter medTransactionAdapter;
    Integer curUserId;

//    ImageButton updateBtn, deleteBtn, cancelBtn, confirmBtn;
//    EditText quantityNew;


    public home_transaction() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //get argument/data
        Bundle bundle = this.getArguments();
        curUserId = bundle.getInt("curUserId");

        return inflater.inflate(R.layout.fragment_home_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //recycle view
        medicineTransactionList = new Vector<>();

//        medicineTransactionList.add(new MedicineTransaction(0,1, "21-03-2023", "Medicine 1", 15000, 4));

//        DataSingleton.getInstance().getMedTransactionList().forEach(transData->{
//            if(transData.getUserId().equals(curUserId)){
//                medicineTransactionList.add(transData);
//            }
//        });

        medicineTransactionList = DataSingleton.getInstance().getUserMedTransaction();

        medTransactionAdapter = new MedTransactionAdapter(view.getContext());
        medTransactionAdapter.setMedicineTransactions(medicineTransactionList);

        medicineTransactionReView = view.findViewById(R.id.home_transaction_ReView);
        medicineTransactionReView.setAdapter(medTransactionAdapter);
        medicineTransactionReView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        noTransactionText = view.findViewById(R.id.home_transaction_NoTransText);

        if(DataSingleton.getInstance().getUserMedTransaction().isEmpty()){
            noTransactionText.setVisibility(View.VISIBLE);
            medicineTransactionReView.setVisibility(View.GONE);
        }else{
            noTransactionText.setVisibility(View.GONE);
            medicineTransactionReView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        medicineTransactionList = new Vector<>();
        medicineTransactionList = DataSingleton.getInstance().getUserMedTransaction();
        medTransactionAdapter.setMedicineTransactions(medicineTransactionList);
        medicineTransactionReView.setAdapter(medTransactionAdapter);
        medicineTransactionReView.setLayoutManager(new LinearLayoutManager(getContext()));

        if(DataSingleton.getInstance().getUserMedTransaction().isEmpty()){
            noTransactionText.setVisibility(View.VISIBLE);
            medicineTransactionReView.setVisibility(View.GONE);
        }else{
            noTransactionText.setVisibility(View.GONE);
            medicineTransactionReView.setVisibility(View.VISIBLE);
        }
    }
}

//public class home_transaction extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public home_transaction() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment home_transaction.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static home_transaction newInstance(String param1, String param2) {
//        home_transaction fragment = new home_transaction();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home_transaction, container, false);
//    }
//}