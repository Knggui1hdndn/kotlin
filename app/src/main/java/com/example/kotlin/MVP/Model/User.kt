package com.example.kotlin.MVP.Model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String?,
    @SerializedName("friends")
    val friends: List<Friend>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String
){
    fun validate():String  {
        return if (name.isNotEmpty() && !email.isNullOrEmpty()) {
            "Login thành công"

        }else{
            if (name.isNullOrEmpty() && email.isNullOrEmpty()) {
                "Không bỏ trống"
            }else{
                if(name.isNullOrEmpty() ) {
                    "Không bỏ trống name"
                } else {
                    "Không bỏ trống email"
                }
            }
        }
    }
}