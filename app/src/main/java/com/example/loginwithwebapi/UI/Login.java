package com.example.loginwithwebapi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.loginwithwebapi.Api.ApiUtils;
import com.example.loginwithwebapi.Api.IUserAPI;
import com.example.loginwithwebapi.MainActivity;
import com.example.loginwithwebapi.Models.ResObj;
import com.example.loginwithwebapi.Models.Users;
import com.example.loginwithwebapi.R;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private ImageButton btnLogin;
    private EditText inputUsername;
    private EditText inputPassword;
    IUserAPI iUserAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
         inputUsername=findViewById(R.id.email);
         inputPassword=findViewById(R.id.password);
        btnLogin=findViewById(R.id.signin);
iUserAPI= ApiUtils.getUserService();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();
                //validate form
                if(validateLogin(username, password)){
                    //do login
                    doLogin(username, password);
                }
            }
        });

    }
    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void doLogin(final String username,final String password){
        Call call = iUserAPI.Login(username,password);
        call.enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    Users users = (Users) response.body();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}