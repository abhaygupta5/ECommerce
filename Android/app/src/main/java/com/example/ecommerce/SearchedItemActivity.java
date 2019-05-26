package com.example.ecommerce;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class SearchedItemActivity extends AppCompatActivity {

    private String productCategory;
    private String searchQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_item);

        searchQuery = getIntent().getStringExtra("queryString");
        productCategory = getIntent().getStringExtra("Category");

    }

    @Override
    protected void onStart() {
        super.onStart();
        try{
            Log.d("searchActivity", searchQuery);
        }catch (Exception e){
            Log.d("searchActivity", "null");
            e.printStackTrace();
        }
        Fragment fragment = ProductListFragment.newProductListFragment(productCategory,searchQuery);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.productRecyclerViewHolder, fragment);
        fragmentTransaction.commit();
    }

    public void getByProductId(View view){
        Intent intent = new Intent(SearchedItemActivity.this, ProductDetailActivity.class);
        intent.putExtra("productId", view.getContentDescription());
        startActivity(intent);
    }
}
