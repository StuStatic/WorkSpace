package com.ylg.workspace.workspace.http;

import com.ylg.workspace.workspace.activity.personaldetails.bean.Business;
import com.ylg.workspace.workspace.activity.personaldetails.bean.DemandFrag;
import com.ylg.workspace.workspace.activity.personaldetails.bean.FeedBackFrag;
import com.ylg.workspace.workspace.activity.personaldetails.bean.MakeAnAppointFrag;
import com.ylg.workspace.workspace.activity.personaldetails.bean.MyActivity;
import com.ylg.workspace.workspace.activity.personaldetails.bean.NotMyActivity;
import com.ylg.workspace.workspace.activity.service.bean.Service;
import com.ylg.workspace.workspace.activity.service.bean.ServiceType;
import com.ylg.workspace.workspace.bean.ExerciseRecommend;
import com.ylg.workspace.workspace.bean.Info;
import com.ylg.workspace.workspace.bean.NeiborCompany;
import com.ylg.workspace.workspace.bean.SlidePic;
import com.ylg.workspace.workspace.bean.SlideServicePic;
import com.ylg.workspace.workspace.bean.SpaceList;
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

    //添加意见反馈
    @POST("Opinion/addOpinion")
    Call<Service> feedBack(@Query("spaceId") String s1, @Query("userId") String s2, @Query("userName") String s3,
                           @Query("tel") String s4, @Query("opinionContent") String s5, @Query("spared1") String s6);
    //查询所有的意见反馈
    @POST("Opinion/findByUserId")
    Call<FeedBackFrag> OfindByUserId(@Query("userId") int userId);

    //发布需求
    @POST("GetFacilitator/addGetFacilitator")
    Call<Service> postRequirement(@Query("spaceId") String s1, @Query("userId") String s2, @Query("describe") String s3,
                           @Query("facilitatorType") String s4, @Query("facilitatorLabel") String s5);

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
    @POST("Slider/findByHome")
    Call<SlidePic> getSlidePic();

    //ServiceFragment轮播图片请求
    @POST("Slider/findByServe")
    Call<SlideServicePic> getSlideServicePic();

    //最新资讯
    @POST("Message/findAllMessageToApp")
    Call<Info> getInfo();

    //服务类型
    @POST("FacilitatorLabel/findAll")
    Call<ServiceType> getServiceType();

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
     *
     * @param
     * @return
     */
    //@POST("/Service_Platform/group/update.do")
    // Call<BaseEntity> update(@Query("groupId") String groupId, @Query("groupName") String groupName, @Query("longitude") double longitude, @Query("latitude") double latitude, @Query("location") String location);

    //友邻企业
    @POST("CompanyInfo/findBySpaceId")
    Call<NeiborCompany> neiborCompany(@Query("spaceId") int spaceId);

    //活动推荐
    @POST("Activity/findByState")
    Call<ExerciseRecommend> exerciseRecommend(@Query("activityState") int activityState);

    //空间列表
    @POST("Space/findAllSpace")
    Call<SpaceList> getSpaceListData(@Query("city") String city);

    //查找我的企业的信息
    @POST("CompanyInfo/findMyCompany")
    Call<Business> findMyCompany(@Query("companyId") String companyId);

    //查找我的活动的信息
    @POST("ActivityApply/findByUserId")
    Call<MyActivity> findByUserIdMyActivity(@Query("userId") int userId,@Query("state") String state);

    //查找我的活动的信息
    @POST("ActivityApply/findByUserId")
    Call<NotMyActivity> findByUserIdMyActivity1(@Query("userId") int userId, @Query("state") String state);

    //查找我的历史的需求
    @POST("GetFacilitator/findByUserId")
    Call<DemandFrag> findByUserIdMyHisDemand(@Query("userId") int userId);

    //查找我的历史的预约
    @POST("Visitor/findVisitorByUserId")
    Call<MakeAnAppointFrag> findVisitorByUserId(@Query("userId") int userId);



}