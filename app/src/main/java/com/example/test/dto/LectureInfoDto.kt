package com.example.test.dto

import com.google.gson.annotations.SerializedName

data class LectureInfoDto(
    @SerializedName("courseId")val courseId : String, //서버에서는 itemId라는 값을 가져와서,  app에선 id라는 값으로
    @SerializedName("subject")val subject : String,
    @SerializedName("learningLevel")val learningLevel : String,
    @SerializedName("level")val level:String,
    @SerializedName("grade")val grade:String
) {
}