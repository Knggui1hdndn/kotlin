package com.example.messenger.model

import java.sql.Timestamp

data class Comment(
    val uid: String?,
    val feedbackUid: String?,
    override var message: String?,
    override var timestamp: Timestamp?,
    override var content: String?
) : Body(message, timestamp, content) {

    constructor() : this(null, null, null, null, null)

    override fun toString(): String {
        return "Comment(uid=$uid, feedbackUid=$feedbackUid, message=$message, timestamp=$timestamp, content=$content)"
    }

}



