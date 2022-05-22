package com.live.clg_project;


import com.live.clg_project.Model.LocalBodyModel;
import com.live.clg_project.Model.UserData1;
import com.live.clg_project.Model.UsersData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface Methods {


    @GET("Users")
    Call<UsersData> getAllData(@Query("filter[phone][_eq]") String phone);

    @GET("Localbodyinfo")
    Call<LocalBodyModel> getLocalBody();


    @GET("Users")
    Call<UsersData>  getProfileData(@Query("filter[house_number][_eq]") String HouseNumber);

    @POST("Users")
    Call<UserData1> postUserdata(@Body UserData1 userData1);
}
