package com.easylife.noty.utils.result

/**
 * Created by erenalpaslan on 19.02.2023
 */
sealed interface NotyResult<T> {

    data class Error<T>(val message: String?): NotyResult<T>

    data class Success<T>(val data: T?): NotyResult<T>

}