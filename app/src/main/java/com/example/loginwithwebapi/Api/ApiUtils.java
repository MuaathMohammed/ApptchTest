package com.example.loginwithwebapi.Api;

import com.example.loginwithwebapi.Services.RetrofitService;

public class ApiUtils {
    public static final String BASE_URL = "http://192.168.1.7:45457/";

    public static IUserAPI getUserService(){
        return RetrofitService.getClient(BASE_URL).create(IUserAPI.class);
    }
    public static IBlogApi getBlogService(){
        return RetrofitService.getClient(BASE_URL).create(IBlogApi.class);
    }
}
