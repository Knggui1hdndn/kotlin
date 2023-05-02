package com.example.kotlin.MVP.Model


import com.google.gson.annotations.SerializedName

data class Friend(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("old")
    val old: Int?
) {
    constructor() : this(null, null, null)
    constructor(
        id: Int?,
        name: String?
    ) : this(id, name, null)

    override fun toString(): String {
        return "Friend(id=$id, name=$name, old=$old)"
    }


}