package com.example.sathya.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sathya.myapplication.model.GetData;
import com.example.sathya.myapplication.rest.ApiClient;
import com.example.sathya.myapplication.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<GetData> call = apiService.getTopRatedMovies();
        call.enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                ((TextView) findViewById(R.id.txtView)).setText(response.body().getName());
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
}
