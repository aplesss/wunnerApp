package com.production.wunner.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.production.wunner.Model.Station;
import com.production.wunner.Model.Team;
import com.production.wunner.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetWunnerDataService {
    @POST("login")
    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    Call<User> LoginUser(@Body UserLogin userLogin);
    @FormUrlEncoded
    @POST("login")
    Call<User> LoginUsers(@Field("userName") String name, @Field("userPassword")String password);
    public class UserLogin{
        @SerializedName("userName")
        @Expose
        private String  UserName;
        @SerializedName("userPassword")
        @Expose
        private String UserPass;

        public UserLogin(String UserName, String userPass) {
            this.UserName = UserName;
            this.UserPass = userPass;
        }
    }
    @GET("getteam")
    Call<Team> GetTeam(@Query("teamID") String team);
    @GET("getstation")
    Call<Station> GetStation(@Query("stationID") String team);

}
