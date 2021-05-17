package com.example.myapplicationtest2.Remote;

import com.example.myapplicationtest2.ImageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("images/")
    Call<List<ImageResponse>> getAllImages();
}
