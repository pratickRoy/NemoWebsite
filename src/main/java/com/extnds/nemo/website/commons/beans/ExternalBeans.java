package com.extnds.nemo.website.commons.beans;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class ExternalBeans {

    @Bean
    public Retrofit retrofit(@Value("${backend.uri}")  String uri) {

        return new Retrofit.Builder()
            .baseUrl(uri)
            .client(new OkHttpClient()
                .newBuilder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}
