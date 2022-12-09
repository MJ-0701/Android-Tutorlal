package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test.dto.LectureInfoDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getInfo() {
        RetrofitObject.getLectureInfoApi().getLectureInfo(35).enqueue(
            object : Callback<LectureInfoDto> {
                override fun onResponse(
                    call: Call<LectureInfoDto>,
                    response: Response<LectureInfoDto>
                ) {
                    if(response.isSuccessful.not()) {
                        return
                    }

                    response.body()?.courseId?.let { Log.d(TAG, it) }
                    response.body()?.subject?.let { Log.d(TAG, it) }
                    response.body()?.learningLevel?.let { Log.d(TAG, it) }
                    response.body()?.level?.let { Log.d(TAG, it) }
                    response.body()?.grade?.let { Log.d(TAG, it) }
                }

                override fun onFailure(call: Call<LectureInfoDto>, t: Throwable) {
                    // 실패 로그
                    Log.d(TAG,t.toString())
                }
            }
        )
    }

    companion object{
        private const val TAG = "MainActivity";
    }
}