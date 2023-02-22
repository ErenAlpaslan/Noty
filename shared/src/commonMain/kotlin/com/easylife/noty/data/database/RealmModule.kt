package com.easylife.noty.data.database

import com.easylife.noty.data.entity.Note
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 19.02.2023
 */
val realmModule = module {
    single {
        val configuration = RealmConfiguration.create(
            schema = setOf(
                Note::class
            )
        )
        Realm.open(configuration)
    }
}