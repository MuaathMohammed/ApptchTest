package com.example.loginwithwebapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.loginwithwebapi.Api.ApiUtils;
import com.example.loginwithwebapi.Api.IBlogApi;
import com.example.loginwithwebapi.Models.Blogs;
import com.example.loginwithwebapi.View.BlogAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ArrayList<Blogs> arrayList;
BlogAdapter blogAdapter;
Context context;
RecyclerView recyclerView;
IBlogApi iBlogApi;
    public static final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        recyclerView=findViewById(R.id.RcVBlog);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.hasFixedSize();
        iBlogApi= ApiUtils.getBlogService();
        Call<ArrayList<Blogs>> call =iBlogApi.GetBlogs();

        call.enqueue(new Callback<ArrayList<Blogs>>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<ArrayList<Blogs>> call, Response<ArrayList<Blogs>> response) {
                try {
                    Log.d("Here comes the null exception", "get title" + response.body().get(0).getBlogTitle());
                    arrayList = response.body();
                    recyclerView.setAdapter(new BlogAdapter(arrayList,context));
                } catch (Exception e) {
                    Log.d("onResponse", "There is an error", e);
                    e.printStackTrace();
                }
            }
        @Override
        public void onFailure(Call<ArrayList<Blogs>> call,Throwable t) {
            Log.d("onFailure", t.toString());
        }
    });
    }

    }


