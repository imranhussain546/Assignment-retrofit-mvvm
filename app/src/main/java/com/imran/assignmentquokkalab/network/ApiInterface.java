package com.imran.assignmentquokkalab.network;

import com.imran.assignmentquokkalab.model.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("entries")
    Call<Data> callListdata();

}
