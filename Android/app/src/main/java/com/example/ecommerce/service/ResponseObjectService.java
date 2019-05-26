package com.example.ecommerce.service;

import com.example.ecommerce.model.Merchant;
import com.example.ecommerce.model.MerchantProduct;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ResponseObject;
import com.example.ecommerce.model.ResponseObject1;
import com.example.ecommerce.model.ResponseObjectMerchant;
import com.example.ecommerce.model.ResponseObjectString;
import com.example.ecommerce.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ResponseObjectService{


    @GET("/getTopProducts")
    Call<ResponseObject<Product>> getTopProducts();

    @GET("/products/{category}")
    Call<ResponseObject<Product>> getProductByCategory(@Path("category") String category);

    @GET("/merchant/{merchantId}")
    Call<ResponseObjectMerchant> getMerchant(@Path("merchantId") int merchantId);

    @GET("/merchants")
    Call<ResponseObject<MerchantProduct>> getMerchantById(@Query("productId") int productId);

    @GET("/getBestMerchantPriceOfProduct")
    Call<ResponseObject<Merchant>> getBestMerchantPrice(@Query("productId") int productId);

    @GET("/search")
    Call<ResponseObject<Product>> search(@Query("query") String query);

    @POST("/signup")
    Call<ResponseObject1> userSignUp(@Body User user);

    @POST("/login")
    Call<ResponseObjectString> login(@Query("username") String username, @Query("password") String password);

    @DELETE("/logout")
    Call<ResponseObject1> logout(@Query("token") String token);

}
