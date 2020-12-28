package yg.android.model

import com.google.gson.annotations.SerializedName

data class QOD(
    @SerializedName("contents")
    val contents: Contents
)