package com.dev.kodok.kontak.model.RestApi;

import com.dev.kodok.kontak.model.pojo.Result;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by root on 24/08/17.
 */

public class RestManager {
    public static RestApiKontak restApiKontak=null;

    public static final String BASE_URL = "https://private-0f185-recruitment.apiary-mock.com";

    public static RestApiKontak getKontak(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Accept", "Application/JSON").build();
                                return chain.proceed(request);
                            }
                        }).build();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApiKontak= client.create(RestApiKontak.class);
        return restApiKontak;
    }

    public interface RestApiKontak {
        @GET("/api/contacts")
        Call<Result> getKontak();
    }

}
