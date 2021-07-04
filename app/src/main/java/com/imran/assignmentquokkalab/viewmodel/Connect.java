package com.imran.assignmentquokkalab.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.imran.assignmentquokkalab.model.Data;
import com.imran.assignmentquokkalab.model.Entry;
import com.imran.assignmentquokkalab.network.ApiClient;
import com.imran.assignmentquokkalab.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Connect  extends ViewModel {

    private MutableLiveData<Data> datalist;

    public Connect() {
        datalist=new MutableLiveData<>();
    }

    public MutableLiveData<Data> getDatalist()
    {
        Apicall();
        return datalist;
    }

    public void Apicall()
    {

        ApiInterface apiInterface= ApiClient.getClient();
        Call<Data> call=apiInterface.callListdata();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful())
                {
                   datalist.postValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                datalist.postValue(null);
            }
        });
    }
}
