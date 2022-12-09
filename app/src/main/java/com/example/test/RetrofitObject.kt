package com.example.test

import com.example.test.service.LectureService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    private fun getLectureRetrofit() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    fun getLectureInfoApi() : LectureService {
        return getLectureRetrofit().create(LectureService::class.java)
    }

}