package com.example.myportofolioapp.Api;

import com.example.myportofolioapp.Model.ItemVidio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceVideo  {

    @GET("data_api")
    Call<List<ItemVidio>> request_video();

}
