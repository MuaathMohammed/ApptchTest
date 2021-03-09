package com.example.loginwithwebapi.Api;

import com.example.loginwithwebapi.Models.Blogs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IBlogApi {
    @Headers("Content-Type: text/plain")
    @GET("api/Blogs")
    Call<ArrayList<Blogs>> GetBlogs();
}
