package com.example.hoang.project_demo_3.retrofit.retrofit;

import com.example.hoang.project_demo_3.retrofit.network.ApiServices;
import com.example.hoang.project_demo_3.retrofit.network.CategoryServices;
import com.example.hoang.project_demo_3.retrofit.network.ProductService;

import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {
    private static final String LOCAL_BASE_URL = "https://floating-ocean-84341.herokuapp.com/api/";



    public static ApiServices getApiervice() {
        return new retrofit2.Retrofit.Builder()
                .baseUrl(LOCAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiServices.class);
    }

    public static ProductService getProductService() {
        return new retrofit2.Retrofit.Builder()
                .baseUrl(LOCAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ProductService.class);
    }

    public static CategoryServices getCategoryService() {
        return new retrofit2.Retrofit.Builder()
                .baseUrl(LOCAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(CategoryServices.class);
    }
}

