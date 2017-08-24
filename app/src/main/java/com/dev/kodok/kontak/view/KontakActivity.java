package com.dev.kodok.kontak.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.dev.kodok.kontak.R;
import com.dev.kodok.kontak.model.RestApi.RestManager;
import com.dev.kodok.kontak.model.adapter.AdapterKontak;
import com.dev.kodok.kontak.model.pojo.Kontak;
import com.dev.kodok.kontak.model.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class KontakActivity extends AppCompatActivity {
    private AdapterKontak adapterKontak;
    private List<Kontak> kontaks;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        kontaks = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lvKontak);

        RestManager.RestApiKontak service = RestManager.getKontak();
        Call<Result> resultCall = service.getKontak();
        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                System.out.println(result);
                kontaks = result.getData();
                adapterKontak = new AdapterKontak(KontakActivity.this, kontaks);
                listView.setAdapter(adapterKontak);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}
