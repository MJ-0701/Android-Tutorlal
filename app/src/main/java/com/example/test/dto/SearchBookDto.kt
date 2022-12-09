package com.example.test.dto

import com.example.test.dto.Book
import com.google.gson.annotations.SerializedName

data class SearchBookDto(
    @SerializedName("title") val title:String,
    @SerializedName("item") val books:List<Book>
) {
}