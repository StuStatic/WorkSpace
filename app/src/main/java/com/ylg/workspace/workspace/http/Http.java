package com.ylg.workspace.workspace.http;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Http {

    public static final String API_URL = "http://www.yiliangang.net:8012/workSpace/";
//    public static final String API_URL = "http://192.168.1.216:8080/workSpace/";
    private static Retrofit retrofit;

    public static Retrofit getInstance(){
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

//    private void getData() {
//
//        HttpAPI httpAPI = Http.getInstance().create(HttpAPI.class);
//        httpAPI.textPic().enqueue(new Callback<BackPicture>() {
//            @Override
//            public void onResponse(Call<BackPicture> call, Response<BackPicture> response) {
//                BackPicture bp = response.body();
//                Log.e("zp", bp.toString());
//                if (bp != null) {
//                    list.clear();
//                    list.addAll(bp.getBack());
//                    //Toast.makeText(TextBackGround.this, bp.getMsg(), Toast.LENGTH_SHORT).show();
//                    gv.setAdapter(new BGTextAdapter(list, TextBackGround.this));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BackPicture> call, Throwable t) {
//                Log.e("zp", t.toString());
//                Toast.makeText(TextBackGround.this, t.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public static final String API_URL1 = "http://192.168.6.219:8080/payment/Payment/";
    //    public static final String API_URL = "http://192.168.1.216:8080/workSpace/";
    private static Retrofit retrofit1;

    public static Retrofit getInstance1(){
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