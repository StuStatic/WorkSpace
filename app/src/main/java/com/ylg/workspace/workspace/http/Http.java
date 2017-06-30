package com.ylg.workspace.workspace.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Http {

    private static final String API_URL = "http://www.yiliangang.net:8012/TV/";
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

}