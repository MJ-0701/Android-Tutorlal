package com.example.test.service

import com.example.test.dto.LectureInfoDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LectureService {

    @GET("/api/v1/scraping/getInfo")
    fun getLectureInfo(
        @Query("id") id:Long

    ): Call<LectureInfoDto>
}