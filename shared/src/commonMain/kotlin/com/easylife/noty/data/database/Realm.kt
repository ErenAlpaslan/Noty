package com.easylife.noty.data.database

import com.easylife.noty.data.entity.Note
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

/**
 * Created by erenalpaslan on 19.02.2023
 */
val realm: Realm by lazy {
    val configuration = RealmConfiguration.create(
        schema = setOf(
            Note::class
        )
    )
    Realm.open(configuration)
}