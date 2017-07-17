package com.ylg.workspace.workspace.http;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ylg.workspace.workspace.activity.service.bean.Service;
import com.ylg.workspace.workspace.view.IphoneDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public class FileUploadManager {

    private static final String ENDPOINT = "http://192.168.1.216:8080/workSpace/";
    private static String TAG = "zp";

    public interface FileUploadService {

        /**
         * 上传文字
         */
        @Multipart
        @POST("file/file_textpush")
        Call<Service> uploadText(@Query("userId") String s1, @Query("count") String s2,
                                 @Query("backgroundPictureId") String s3,
                                 @Query("fileStartHour") String s4, @Query("fileStartMin") String s5,
                                 @PartMap Map<String, RequestBody> imgs1,
                                 @Part("text\";") RequestBody imgs);


        @Multipart
        @POST("FacilitatorInfo/addInfo")
        Call<Service> registerService(@Query("userId") String s1, @Query("firmName") String s2,
                                      @Query("businessScope") String s3, @Query("contacts") String s4,
                                      @Query("tel") String s5, @Query("facilitatorType") String s6,
                                      @Query("facilitatorState") int i,
                                      @Part("file\"; filename=\"file\"") RequestBody firmLogo);

        /**
         * 访客预约
         */
        @Multipart
        @POST("Visitor/addVisitorOrUpdate")
        Call<Service> orderVisitor(@Query("userId") String s1, @Query("visitorName") String s2,
                                   @Query("visitorTel") String s3, @Query("spared1") String s4,
                                   @Query("userName") String s5, @Query("visitInfo") String s6,
                                   @Query("peopleNum") int s7, @Query("vtime") String s8,
                                   @Query("sex") String s9,
                                   @Query("accessType") int i,
                                   @PartMap Map<String, RequestBody> visitorPicture);
//@Query("peopleNum") String s7, @Query("visitTime") String s8,@Query("visitorTel") String s3, @Query("spared1") String s4,
//@Query("sex") String s9,

        /**
         * 注册服务商
         *
         * @return
         */
        @Multipart
        @POST("FacilitatorInfo/addInfo")
        Call<Service> uploadImage(@Query("userId") String s1, @Query("firmName") String s2,
                                  @Query("businessScope") String s3, @Query("contacts") String s4,
                                  @Query("tel") String s5, @Query("facilitatorType") String s6,
                                  @Query("facilitatorState") int i,
                                  @PartMap Map<String, RequestBody> firmLogo
        );
    }

    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final FileUploadService apiManager = sRetrofit.create(FileUploadService.class);

    public static void registerService(String s1, String s2, String s3, String s4, String s5, String s6, String s7, int i, final Context context) {

//        Map<String, RequestBody> photos1 = new HashMap<>();
//        if (alias.size() > 0) {
//            for (int i = 0; i < alias.size(); i++) {
//                photos1.put("Alias\";", RequestBody.create(MediaType.parse("multipart/form-data"), alias.get(i)));
//            }
//        }
        File file = new File(s7);
        RequestBody rb = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        RequestBody rb = new MultipartBody.Builder().setType(MultipartBody.FORM)
//                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file))
//                .build();
        Call<Service> call = apiManager.registerService(s1, s2, s3, s4, s5, s6, i, rb);
        call.enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                Log.d("zp", "onResponse: " + response.body().toString());
                Service b = response.body();
                if (b.getCode().equals("200")) {
                    Toast.makeText(context, "上传成功", Toast.LENGTH_SHORT).show();
                    ((Activity) context).finish();
                } else {
                    Toast.makeText(context, "上传失败", Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onResponse() called with: " + "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: " + "call = [" + call + "], t = [" + t + "]");
            }
        });
    }

    public static void upload(String s1, String s2, String s3, String s4, ArrayList<String> alias, String text, String backgroundPictureId, final Context context) {

        Map<String, RequestBody> photos1 = new HashMap<>();
        if (alias.size() > 0) {
            for (int i = 0; i < alias.size(); i++) {
                photos1.put("Alias\";", RequestBody.create(MediaType.parse("multipart/form-data"), alias.get(i)));
            }
        }
        RequestBody rb = RequestBody.create(MediaType.parse("multipart/form-data"), text);
        Call<Service> call = apiManager.uploadText(s1, s2, backgroundPictureId, s3, s4, photos1, rb);
        call.enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {

                Service b = response.body();
                if (b.getCode().equals("200")) {
                    Toast.makeText(context, "上传成功", Toast.LENGTH_SHORT).show();
                    ((Activity) context).finish();
                } else {
                    Toast.makeText(context, "上传失败", Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onResponse() called with: " + "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: " + "call = [" + call + "], t = [" + t + "]");
            }
        });
    }

    //注册服务商
    public static void uploadMany(String s1, String s2, String s3, String s4, String s5, String s6, ArrayList<String> paths, int i1, final Context context, final IphoneDialog id) {
        Map<String, RequestBody> photos = new HashMap<>();
        //Map<String, RequestBody> photos1 = new HashMap<>();
        if (paths.size() > 0) {
            for (int i = 0; i < paths.size(); i++) {
                File file = new File(paths.get(i));
                photos.put("file\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
            }
        }

        Call<Service> stringCall = apiManager.uploadImage(s1, s2, s3, s4, s5, s6, i1, photos);
        //Call<Service> stringCall = apiManager.orderVisitor(s1, s2, s3, s4, s5, s6, i7, s8, s9, i1, photos);
        stringCall.enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                id.dismiss();
                Log.d(TAG, "onResponse: " + response.body().toString());
                Service b = response.body();
                if (b.getCode().equals("200")) {
                    Toast.makeText(context, "上传成功", Toast.LENGTH_SHORT).show();
                    ((Activity) context).finish();
                } else {
                    Toast.makeText(context, "上传失败", Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onResponse() called with: " + "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                id.dismiss();
                Toast.makeText(context, "上传失败", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure() called with: " + "call = [" + call + "], t = [" + t + "]");
            }
        });
    }

    //访客预约
    public static void order(String s1, String s2, String s3, String s4, String s5, String s6, int s7, String s8, String s9, ArrayList<String> paths, int i1, final Context context, final IphoneDialog id) {
        Map<String, RequestBody> photos = new HashMap<>();
        if (paths.size() > 0) {
            Log.d("zp", "order: " + paths.size());
            for (int i = 0; i < paths.size(); i++) {
                File file = new File(paths.get(i));
                photos.put("file\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
            }
        }
        HttpAPI httpAPI = Http.getInstance().create(HttpAPI.class);
        httpAPI.orderVisitor(s1, s2, s3, s4, s5, s6, s7, s8, s9, i1, photos).enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                id.dismiss();

                Service b = response.body();
                Log.d(TAG, "onResponse: " + response.body().toString());
                if (b.getCode().equals("200")) {
                    Toast.makeText(context, "上传成功", Toast.LENGTH_SHORT).show();
                    ((Activity) context).finish();
                } else {
                    Toast.makeText(context, "上传失败", Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onResponse() called with: " + "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                id.dismiss();
                Toast.makeText(context, "上传失败", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure() called with: " + "call = [" + call + "], t = [" + t + "]");
            }
        });
    }

    //报修
    public static void questionFix(String s1, String s2, String s3, String s4, String s5, String s6, ArrayList<String> paths, final Context context, final IphoneDialog id) {
        Map<String, RequestBody> photos = new HashMap<>();
        if (paths.size() > 0) {
            Log.d("zp", "order: " + paths.size());
            for (int i = 0; i < paths.size(); i++) {
                File file = new File(paths.get(i));
                photos.put("file\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
            }
        }
        HttpAPI httpAPI1 = Http.getInstance().create(HttpAPI.class);
        httpAPI1.questionFix(s1, s2, s3, s4, s5, s6, photos).enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                id.dismiss();

                Service b = response.body();
                Log.d(TAG, "onResponse: " + response.body().toString());
                if (b.getCode().equals("200")) {
                    Toast.makeText(context, "上传成功", Toast.LENGTH_SHORT).show();
                    ((Activity) context).finish();
                } else {
                    Toast.makeText(context, "上传失败", Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onResponse() called with: " + "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                id.dismiss();
                Toast.makeText(context, "上传失败", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure() called with: " + "call = [" + call + "], t = [" + t + "]");
            }
        });
    }
}
