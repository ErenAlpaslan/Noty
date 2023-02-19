package com.easylife.noty.data.entity

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * Created by erenalpaslan on 19.02.2023
 */
data class Note(
    @PrimaryKey
    var id: ObjectId = ObjectId.create(),
    var timestamp: Long,
    var title: String?,
    var content: String?,
): RealmObject
