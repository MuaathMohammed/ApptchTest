package com.example.loginwithwebapi.Api;

import com.example.loginwithwebapi.Models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IUserAPI {
    @GET("api/Users/{username},{password}")
     Call<Users> Login(@Path("username") String username,@Path("password") String password) ;

}
