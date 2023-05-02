package com.example.messenger.model

import com.google.firebase.database.Exclude
import com.google.firebase.database.PropertyName
import java.sql.Timestamp

open class Body(
    open val message: String?,
    open val timestamp: Timestamp?,
    open val content: String?
) {
    constructor() :
            this(null, null, null)
}