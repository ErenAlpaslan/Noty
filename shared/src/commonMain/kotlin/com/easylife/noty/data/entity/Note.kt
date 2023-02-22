package com.easylife.noty.data.entity

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * Created by erenalpaslan on 19.02.2023
 */
class Note: RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()
    var timestamp: Long = 0L
    var title: String? = null
    var content: String? = null
}
