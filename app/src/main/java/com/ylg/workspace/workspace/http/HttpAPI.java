package com.ylg.workspace.workspace.http;

import com.ylg.workspace.workspace.activity.service.bean.Service;
import com.ylg.workspace.workspace.bean.ExerciseRecommend;
import com.ylg.workspace.workspace.bean.Info;
import com.ylg.workspace.workspace.bean.NeiborCompany;
import com.ylg.workspace.workspace.bean.SlidePic;
import com.ylg.workspace.workspace.http.bean.FindByActivityId;
import com.ylg.workspace.workspace.http.bean.FindByApplyTel;
import com.ylg.workspace.workspace.http.bean.FindByUserId;
import com.ylg.workspace.workspace.http.bean.Login;
import com.ylg.workspace.workspace.http.bean.Register;
import com.ylg.workspace.workspace.http.bean.SendVerify;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface HttpAPI {

    //意见反馈
    @POST("Opinion/addOpinion")
    Call<Service> feedBack(@Query("spaceId") String s1, @Query("userId") String s2, @Query("userName") String s3,
                           @Query("tel") String s4, @Query("opinionContent") String s5, @Query("spared1") String s6);

    //登陆
    @POST("Login/Login")
    Call<Login> login(@Query("tel") String tel, @Query("password") String password);

    //注册1（短信）
    @POST("Login/sendVerify")
    Call<SendVerify> sendVerify(@Query("tel") String tel);

    //注册2
    @POST("Login/register")
    Call<Register> register(@Query("tel") String tel, @Query("password") String password, @Query("userType") String userType, @Query("registerTime") String registerTime, @Query("state") String state, @Query("verifyNumPro") String verifyNumPro);

    //修改密码(根据短信)1
    @POST("Login/sendVerifyPassword")
    Call<SendVerify> sendVerifyPassword(@Query("tel") String tel);

    //修改密码(根据短信)2
    @POST("Login/changeNotePassword")
    Call<Register> changeNotePassword(@Query("tel") String tel, @Query("password") String password, @Query("verifyNumPro") String verifyNumPro);

    //修改密码（根据密码）
    @POST("Login/changePassword")
    Call<Register> changePassword(@Query("tel") String tel, @Query("password") String password, @Query("oriPassword") String oriPassword);

    //访客预约
    @Multipart
    @POST("Visitor/addVisitorOrUpdate")
   // @POST("MaintainInfo/addMaintainInfo")
    Call<Service> orderVisitor(@Query("userId") String s1, @Query("visitorName") String s2,
                               @Query("visitorTel") String s3, @Query("spared1") String s4,
                               @Query("userName") String s5, @Query("visitInfo") String s6,
                               @Query("peopleNum") int s7, @Query("visitTime") String s8,
                               @Query("sex") String s9,
                               @Query("accessType") int i,
                               @PartMap Map<String, RequestBody> visitorPicture);

    //是否有此用户
    @POST("Login/findUser")
    Call<Register> findUser(@Query("phone") String phone);

    //添加活动
    @POST("Activity/addActivity")
    Call<Register> addActivity(@Query("title") String title, @Query("activityDescribe") String activityDescribe,
                               @Query("pictureSite") String pictureSite, @Query("activityType") int activityType,
                               @Query("spaceId") int spaceId, @Query("issueUserId") int issueUserId,
                               @Query("issueCompanyId") int issueCompanyId, @Query("issueTime") String issueTime,
                               @Query("starTime") String starTime, @Query("endTime") String endTime,
                               @Query("peopleNum") int peopleNum, @Query("principalName") String principalName,
                               @Query("principalTel") String principalTel, @Query("activityState") int activityState);

    //修改活动
    @POST("Activity/addActivity")
    Call<Register> modifyActivity(@Query("activityId") int activityId, @Query("title") String title, @Query("activityDescribe") String activityDescribe,
                                  @Query("pictureSite") String pictureSite, @Query("activityType") int activityType,
                                  @Query("spaceId") int spaceId, @Query("issueUserId") int issueUserId,
                                  @Query("issueCompanyId") int issueCompanyId, @Query("issueTime") String issueTime,
                                  @Query("starTime") String starTime, @Query("endTime") String endTime,
                                  @Query("peopleNum") int peopleNum, @Query("principalName") String principalName,
                                  @Query("principalTel") String principalTel, @Query("activityState") int activityState);

    //取消活动
    @POST("Activity/cancelActivity")
    Call<Register> cancelActivity(@Query("activityId") int activityId);

    //查找空间编号对应的活动信息
    @POST("Activity/findBySpaceId")
    Call<FindByUserId> findBySpaceId(@Query("spaceId") int spaceId);

    //查找空间编号对应的活动信息
    @POST("Activity/findByUserId")
    Call<FindByUserId> findByUserId(@Query("issueUserId") int issueUserId);

    //添加活动报名信息
    @POST("ActivityApply/addActivityApply")
    Call<Register> addActivityApply(@Query("applyNume") String applyNume, @Query("applyTel") String applyTel,
                                    @Query("applyCompany") String applyCompany, @Query("activityId") int activityId,
                                    @Query("applyTime") String applyTime, @Query("applyState") int applyState);

    //修改活动报名信息
    @POST("Activity/findByUserId")
    Call<Register> addActivityApply2(@Query("applyId") int applyId, @Query("applyNume") String applyNume, @Query("applyTel") String applyTel,
                                     @Query("applyCompany") String applyCompany, @Query("activityId") int activityId,
                                     @Query("applyTime") String applyTime, @Query("applyState") int applyState);

    //取消报名
    @POST("ActivityApply/cancelActivityApply")
    Call<Register> cancelActivityApply(@Query("applyId") int applyId);

    //查找某活动的报名的人
    @POST("ActivityApply/findByActivityId")
    Call<FindByActivityId> findByActivityId(@Query("activityId") int activityId);

    //报名人参加的活动
    @POST("ActivityApply/findByApplyTel")
    Call<FindByApplyTel> findByApplyTel(@Query("applyTel") String applyTel);

    //HomeFragment轮播图片请求
    @POST("Slider/findAll")
    Call<SlidePic> getSlidePic();

    //最新资讯
    @POST("Message/findAllMessage")
    Call<Info> getInfo();

    //报修
    @Multipart
    //@POST("Visitor/addVisitorOrUpdate")
    @POST("MaintainInfo/addMaintainInfo")
    Call<Service> questionFix(@Query("userId") String s1, @Query("alias") String s2,
                               @Query("type") String s3, @Query("info") String s4,
                               @Query("appointmentTime") String s5, @Query("address") String s6,
                               @PartMap Map<String, RequestBody> photo);

//    //绑定设备
//    @FormUrlEncoded
//    @POST("tv/tv_UserAndTv")
//    Call<Bind> bind(@Field("userId") String s1, @Query("tvId") String s2, @Field("tvStatus") String s3, @Field("tvAddress") String s4, @Query("tvLat") String s5, @Query("tvLng") String s6);
//

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

    //友邻企业
    @POST("CompanyInfo/findBySpaceId")
    Call<NeiborCompany> neiborCompany (@Query("spaceId") int spaceId);

    //活动推荐
    @POST("Activity/findByState")
    Call<ExerciseRecommend> exerciseRecommend (@Query("activityState") int activityState);

}