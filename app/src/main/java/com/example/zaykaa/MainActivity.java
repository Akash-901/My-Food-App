package com.example.zaykaa;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zaykaa.adapters.MainAdapter;
import com.example.zaykaa.databinding.ActivityMainBinding;
import com.example.zaykaa.models.MainModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //getting activity main recycler view
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<MainModel> list= new ArrayList<>();
        list.add(new MainModel(R.drawable.pulao,"Pulao","140","Pulao with spicy gravy"));
        list.add(new MainModel(R.drawable.kebab,"Kebab","150","Kebab with tandoori roti"));
        list.add(new MainModel(R.drawable.kofta,"Kofta","130","Kofta with naan"));
        list.add(new MainModel(R.drawable.korma,"Korma","250","Kebab with tandoori roti"));
        list.add(new MainModel(R.drawable.kheer,"Kheer","100","Kheer with extra dry fuits"));
        list.add(new MainModel(R.drawable.lassi,"Lassi","100","Lassi with ice cream"));
        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this , orderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}