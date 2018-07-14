package com.example.hoang.project_demo_3.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hoang.project_demo_3.R;
import com.example.hoang.project_demo_3.ViewHolder.GoodsRecyclerViewAdapter;
import com.example.hoang.project_demo_3.entity.MyProduct;
import com.example.hoang.project_demo_3.retrofit.network.ProductService;
import com.example.hoang.project_demo_3.retrofit.retrofit.ApiUtils;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Goods_Activity extends AppCompatActivity {
    MaterialSearchView searchView;
    List<MyProduct> list_goods;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_activity);

        Intent intent = getIntent();
        int id = (int) intent.getExtras().get("id");

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Search");

        searchView = (MaterialSearchView)findViewById(R.id.search_view);

        ProductService productService = ApiUtils.getProductService();
        productService.getProductbyCategory(id).enqueue(new Callback<List<MyProduct>>() {
            @Override
            public void onResponse(Call<List<MyProduct>> call, Response<List<MyProduct>> response) {
                if (response.isSuccessful()) {
                    list_goods = response.body();
                    addToAdapter(list_goods);
                }
            }

            @Override
            public void onFailure(Call<List<MyProduct>> call, Throwable t) {

            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
            }

            @Override
            public void onSearchViewClosed() {
                addToAdapter(list_goods);
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null &&  !newText.isEmpty()){
                    List<MyProduct> lstFound = new ArrayList<MyProduct>();
                    for(MyProduct x:list_goods){
                        if(x.getTitle().toLowerCase().contains(newText.toLowerCase())){
                            lstFound.add(x);
                        }
                    }
                    addToAdapter(lstFound);
                }
                return true;
            }
        });
    }


    public void addToAdapter(List<MyProduct> list) {
        RecyclerView recyclerViewGoods = (RecyclerView) findViewById(R.id.recycler_list_goods);
        recyclerViewGoods.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewGoods.setLayoutManager(layoutManager);
        GoodsRecyclerViewAdapter adapter = new GoodsRecyclerViewAdapter(this, list);
        recyclerViewGoods.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_item,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }
}
