package com.easylife.noty.core.common.util

/**
 * Created by erenalpaslan on 9.01.2023
 */
sealed interface NotyResult<T> {

    data class Error<T>(val message: String?): NotyResult<T?>

    data class Success<T>(val data: T?): NotyResult<T?>
}
