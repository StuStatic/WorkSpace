package com.ylg.workspace.workspace.http;

public interface HttpAPI {

//    //绑定设备
//    @FormUrlEncoded
//    @POST("tv/tv_UserAndTv")
//    Call<Bind> bind(@Field("userId") String s1, @Query("tvId") String s2, @Field("tvStatus") String s3, @Field("tvAddress") String s4, @Query("tvLat") String s5, @Query("tvLng") String s6);
//
//    //注册
//    @POST("user/user_addUser")
//    Call<Register> register(@Query("username") String s1, @Query("password") String s2);
//
//    //登录
//    @GET("user/user_loginByUsernameAndPassword")
//    Call<Login> login(@Query("username") String s1, @Query("password") String s2);
//
//    //上传图片
//    @Multipart
//    @POST("file/file_morefile")
//    Call<Bind> uploadImage(@Query("userId") String s1, @Query("count") String s2,
//                           @PartMap Map<String, RequestBody> imgs1,
//                           @PartMap Map<String, RequestBody> imgs2);
//
//
//    //解绑
//    @POST("tv/tv_userUnbundlingTV")
//    Call<Unbind> unbind(@Query("tvId") String s1, @Query("tvAvailable") String s2, @Query("PUnbundling") String s3);
//
//    //文字背景
//    @GET("backpicture/backpicture_selectAllBackGroundPicture")
//    Call<BackPicture> textPic();

    /**
     * 修改用户设备分组
     * @param groupId
     * @return
     */
    //@POST("/Service_Platform/group/update.do")
    // Call<BaseEntity> update(@Query("groupId") String groupId, @Query("groupName") String groupName, @Query("longitude") double longitude, @Query("latitude") double latitude, @Query("location") String location);


}