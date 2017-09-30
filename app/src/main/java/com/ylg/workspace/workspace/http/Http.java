package com.ylg.workspace.workspace.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Http {

   public static final String API_URL = "http://219.143.170.98:10011/workSpace/";
   //public static final String API_URL = "http://192.168.38.149:8080/workSpace/";
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit != null) {
            return retrofit;
        } else {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30, TimeUnit.SECONDS);
            builder.readTimeout(30, TimeUnit.SECONDS);
            builder.writeTimeout(30, TimeUnit.SECONDS);
            OkHttpClient client = builder.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }

    }


    //public static final String API_URL1 = "http://219.143.170.98:10011/payment/Payment/";
    public static final String API_URL1 = "http://192.168.1.216:8080/workSpace/";
    private static Retrofit retrofit1;

    public static Retrofit getInstance1() {
        if (retrofit1 != null) {
            return retrofit1;
        } else {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30, TimeUnit.SECONDS);
            builder.readTimeout(30, TimeUnit.SECONDS);
            builder.writeTimeout(30, TimeUnit.SECONDS);
            OkHttpClient client = builder.build();
            retrofit1 = new Retrofit.Builder()
                    .baseUrl(API_URL1)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit1;
        }

    }

}