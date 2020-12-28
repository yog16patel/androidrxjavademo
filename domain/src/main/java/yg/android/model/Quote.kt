package yg.android.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("author")
    val author: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("length")
    val length: Int,
    @SerializedName("quote")
    val quote: String,
    @SerializedName("tags")
    val tags: List<String>
)