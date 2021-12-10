package com.example.zaykaa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.zaykaa.adapters.ordersAdapter;
import com.example.zaykaa.databinding.ActivityOrderBinding;
import com.example.zaykaa.models.OrdersModel;

import java.util.ArrayList;

public class orderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<OrdersModel> list = new ArrayList<>();
//
//        list.add(new OrdersModel(R.drawable.pulao,"cheese burger", "4","456"));
//        list.add(new OrdersModel(R.drawable.download1,"cheese burger", "4","456"));
//        list.add(new OrdersModel(R.drawable.download1,"cheese burger", "4","456"));
//        list.add(new OrdersModel(R.drawable.download1,"cheese burger", "4","456"));
//        list.add(new OrdersModel(R.drawable.download1,"cheese burger", "4","456"));
        list.add(new OrdersModel(R.drawable.pulao,"Pulao","140","456"));
        list.add(new OrdersModel(R.drawable.kebab,"Kebab","150","456"));
        list.add(new OrdersModel(R.drawable.kofta,"Kofta","130","456"));
        list.add(new OrdersModel(R.drawable.korma,"Korma","250","456"));
        list.add(new OrdersModel(R.drawable.kheer,"Kheer","100","456"));
        list.add(new OrdersModel(R.drawable.lassi,"Lassi","100","456"));
       DBHelper helper = new DBHelper(this);
       list = helper.getOrders();




        ordersAdapter adapter = new ordersAdapter(list, this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}