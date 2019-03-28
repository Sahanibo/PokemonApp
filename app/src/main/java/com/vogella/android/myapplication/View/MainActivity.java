package com.vogella.android.myapplication.View;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vogella.android.myapplication.Controler.MainControler;
import com.vogella.android.myapplication.Model.Pokemon;
import com.vogella.android.myapplication.MyAdapter;
import com.vogella.android.myapplication.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainControler controler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        controler = new MainControler(this);
        controler.onCreate();
    }


    public void showList(List<Pokemon> listPokemon) {
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(listPokemon);
        recyclerView.setAdapter(mAdapter);
    }


}
