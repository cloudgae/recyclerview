package com.example.a1018practice;



import static com.example.a1018practice.ProductAdapter.listener;
import static com.example.a1018practice.ProductAdapter.productList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import android.view.GestureDetector;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView productRecyclerView = findViewById(R.id.productRecyclerView);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "Description for Product 1", R.drawable.c1));
        products.add(new Product("Product 2", "Description for Product 2", R.drawable.tiramisu));
        products.add(new Product("Product 3", "Description for Product 3", R.drawable.tiramisu01));
        products.add(new Product("Product 4", "Description for Product 4", R.drawable.c1));
        products.add(new Product("Product 5", "Description for Product 5", R.drawable.tiramisu01));
        products.add(new Product("Product 6", "Description for Product 6", R.drawable.tiramisu));

        // productList를 원하는 순서로 재배치
        ProductAdapter productAdapter = new ProductAdapter(products, null);
        List<Product> rearrangedList = productAdapter.rearrangeProductList(products);

        // 어댑터 초기화
        productAdapter = new ProductAdapter(rearrangedList, null);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        productRecyclerView.setLayoutManager(layoutManager);

        // RecyclerView에 어댑터 설정
        productRecyclerView.setAdapter(productAdapter);

//        ListView productListView = findViewById(R.id.productListView);
//        GridView productGridView = findViewById(R.id.productGridView);
//        RecyclerView productRecyclerView = findViewById(R.id.productRecyclerView);
//
//        List<Product> products = new ArrayList<>();
//
//
////        List<Product> rearrangedList = rearrangeProductList(productList);
//
//        products.add(new Product("Product 1", "Description for Product 1", R.drawable.c1));
//        products.add(new Product("Product 2", "Description for Product 2", R.drawable.tiramisu));
//        products.add(new Product("Product 3", "Description for Product 3", R.drawable.tiramisu01));
//        products.add(new Product("Product 4", "Description for Product 4", R.drawable.c1));
//        products.add(new Product("Product 5", "Description for Product 5", R.drawable.tiramisu01));
//        products.add(new Product("Product 6", "Description for Product 6", R.drawable.tiramisu));
//
//        // productList를 원하는 순서로 재배치
//        ProductAdapter productAdapter = new ProductAdapter(products, listener);
//        List<Product> rearrangedList = productAdapter.rearrangeProductList(products);
//
//// RecyclerView에 어댑터 설정
//        productRecyclerView.setAdapter(productAdapter);

//        rearrangedList.add(new Product("Product 1", "Description for Product 1", R.drawable.c1));
//        rearrangedList.add(new Product("Product 2", "Description for Product 2", R.drawable.tiramisu));
//        rearrangedList.add(new Product("Product 3", "Description for Product 3", R.drawable.tiramisu01));
//        rearrangedList.add(new Product("Product 4", "Description for Product 4", R.drawable.c1));
//        rearrangedList.add(new Product("Product 5", "Description for Product 5", R.drawable.tiramisu01));
//        rearrangedList.add(new Product("Product 6", "Description for Product 6", R.drawable.tiramisu));

////        ProductAdapter adapter = new ProductAdapter(products);
//
//        // productList를 원하는 순서로 재배치
//        ProductAdapter productAdapter = new ProductAdapter(products, listener);
//        List<Product> rearrangedList = productAdapter.rearrangeProductList(products);
//
//
//        // 어댑터 초기화
////        ProductAdapter adapter = new ProductAdapter(rearrangedList);
//
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
//        productRecyclerView.setLayoutManager(layoutManager);
////        productRecyclerView.setAdapter(adapter);
//
//        // RecyclerView에 어댑터 설정
////        productRecyclerView.setAdapter(adapter);
//
//        productRecyclerView.setAdapter(productAdapter);

    }
}