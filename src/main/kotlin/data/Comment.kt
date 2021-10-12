package data

import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("id")
    val commentId: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("postId")
    val postId: Int,
    @SerializedName("body")
    val postBody: String,
    @SerializedName("name")
    val name: String
)
