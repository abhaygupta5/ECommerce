package com.example.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.model.MerchantProduct;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ResponseObject;
import com.example.ecommerce.model.ResponseObjectBestPrice;
import com.example.ecommerce.model.ResponseProductObject;
import com.example.ecommerce.service.BestPriceService;
import com.example.ecommerce.service.ResponseObjectService;
import com.example.ecommerce.service.ResponseProductService;

import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDetailActivity extends AppCompatActivity {

    private final String BASEURLPRODUCT = ServerConfiguration.BASE_PRODUCT_SERVICE;
    private final String BASEURLMERCHANT = ServerConfiguration.BASE_MERCHANT_SERVICE;

    private ImageView itemImage;
    private TextView merchantName;
    private TextView productDescription;
    private TextView price;
    private TextView productName;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;

    private String productId;
    private Product product;
    private List<MerchantProduct> listOfMerchants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        productId = getIntent().getStringExtra("productId");

    }

    @Override
    protected void onStart() {
        super.onStart();
        itemImage = findViewById(R.id.itemImage);
        merchantName = findViewById(R.id.merchantNameProductDetailPage);
        productDescription = findViewById(R.id.productDescription);
        price = findViewById(R.id.priceProductDetail);
        productName = findViewById(R.id.DetailProductName);
        linearLayout = findViewById(R.id.ProductDetail);
        linearLayout2 = findViewById(R.id.AllMerchantInformation);
        getDetail();
        getBestPrice();
        getMerchants();
    }

    public void getDetail(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURLPRODUCT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        ResponseProductService service = retrofit.create(ResponseProductService.class);
        service.getProductById(Integer.parseInt(productId)).enqueue(new Callback<ResponseProductObject>() {
            @Override
            public void onResponse(Call<ResponseProductObject> call, Response<ResponseProductObject> response) {
                if(response.body()!=null && response.body().isOk()){
                    Log.d("productdetail", response.body().getData().getProductIimages().get(0) +
                            response.body().getData().getDescription() + response.body().getData().getAttribute());
                    product = response.body().getData();
                    updateUI(); //add in last call
                }
                else {
                    Log.d("productdetail ", "not ok");
                }
            }

            @Override
            public void onFailure(Call<ResponseProductObject> call, Throwable t) {
                Log.d("productdetailthisis ", t.getMessage());
            }
        });

    }

    public void getBestPrice(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURLMERCHANT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        BestPriceService service = retrofit.create(BestPriceService.class);
        service.getBestPriceById(Integer.parseInt(productId)).enqueue(new Callback<ResponseObjectBestPrice>() {

            @Override
            public void onResponse(Call<ResponseObjectBestPrice> call, Response<ResponseObjectBestPrice> response) {
                if(response.body()!=null && response.body().isOk()){
                    Log.d("price", response.body().getData());
                    String s[] = response.body().getData().split(":");
                    price.setText(s[0]);
                    merchantName.setText(s[1]);
                }
                else {
                    Log.d("price ", "not ok" + response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ResponseObjectBestPrice> call, Throwable t) {
                Log.d("price ", t.getMessage());
            }
        });
    }

    public void getMerchants(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURLMERCHANT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        ResponseObjectService service = retrofit.create(ResponseObjectService.class);
        service.getMerchantById(Integer.parseInt(productId)).enqueue(new Callback<ResponseObject<MerchantProduct>>() {
            @Override
            public void onResponse(Call<ResponseObject<MerchantProduct>> call, Response<ResponseObject<MerchantProduct>> response) {
                if(response.body()!=null && response.body().isOk()){
                    Log.d("merchantdetail ", response.body().getData().get(0)
                            + " size " + response.body().getData().size());
                    listOfMerchants = response.body().getData();
                    addMerchantInfo();

                }
                else {
                    Log.d("merchantdetail ", "not ok");
                }
            }

            @Override
            public void onFailure(Call<ResponseObject<MerchantProduct>> call, Throwable t) {
                Log.d("merchantdetail ", t.getMessage());
            }
        });
    }

    public void updateUI(){
        if(itemImage!=null){
            Glide.with(ProductDetailActivity.this).load(product.getProductIimages().get(0)).into(itemImage);
        }
        productName.setText(product.getProductName());
        productDescription.setText(product.getDescription());

        for(Map.Entry<String,String> entry : product.getAttribute().entrySet()){
            TextView textView = new TextView(this);
            textView.setText(entry.getKey() +" : " +  entry.getValue());
            linearLayout.addView(textView);
        }
    }

    @Override
    protected void onStop() {
        linearLayout.removeAllViews();
        super.onStop();
    }

    public void addMerchantInfo(){
        for(MerchantProduct merchant: listOfMerchants){


            TextView price = new TextView(ProductDetailActivity.this);
            price.setText("price : " + String.valueOf(merchant.getProductPrice()));
            TextView merchantName = new TextView(ProductDetailActivity.this);
            merchantName.setText("Merchant Name : " + merchant.getMerchantName());
            TextView rating = new TextView(ProductDetailActivity.this);
            rating.setText("rating : " + merchant.getAverageRating());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            linearLayout3 = new LinearLayout(ProductDetailActivity.this);
            linearLayout3.setLayoutParams(params);
            linearLayout3.setOrientation(LinearLayout.VERTICAL);
            linearLayout3.setDividerDrawable(getDrawable(R.drawable.divider_drawable));
            linearLayout3.setShowDividers(LinearLayout.SHOW_DIVIDER_END);
            linearLayout3.setElevation(12);
            linearLayout3.addView(price);
            linearLayout3.addView(merchantName);
            linearLayout3.addView(rating);
            linearLayout2.addView(linearLayout3);
        }
    }
}
