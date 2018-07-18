package com.example.hoang.project_demo_3.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.hoang.project_demo_3.R;
import com.example.hoang.project_demo_3.ViewHolder.OrderRecycleViewAdapter;
import com.example.hoang.project_demo_3.entity.Request;

import java.util.ArrayList;
import java.util.List;

public class Order_History extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    OrderRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__history);
        Button DoneBtn = findViewById(R.id.btnDoneorder);
        recyclerView = findViewById(R.id.listCart);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadListOrder();
        DoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadListOrder() {
        List<Request> order = new ArrayList<Request>();
        Request cart1 = new Request();
        cart1.setPhone("1900");
        cart1.setName("Khanh Dao");
        cart1.setStatus("0");
        cart1.setTotal("17900000");
        cart1.setAddress("Ngo 1 Le Hong Phong");
        Request cart2 = new Request();
        cart2.setPhone("1234");
        cart2.setName("Khanh Dao");
        cart2.setStatus("0");
        cart2.setTotal("179000000");
        cart2.setAddress("Ngo 1 Le Hong Phong");
        order.add(cart1);
        order.add(cart2);
        adapter = new OrderRecycleViewAdapter(order, this);
        recyclerView.setAdapter(adapter);
    }
}
