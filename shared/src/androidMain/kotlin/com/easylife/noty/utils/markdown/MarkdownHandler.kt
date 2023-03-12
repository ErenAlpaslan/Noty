package com.easylife.noty.utils.markdown

import android.content.Context
import com.easylife.noty.utils.dispatchers.NotyDispatchers
import io.noties.markwon.Markwon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

/**
 * Created by erenalpaslan on 12.03.2023
 */
class MarkdownHandler(
    val dispatchers: NotyDispatchers,
    val context: Context
): KoinComponent {
    private val markwon = Markwon.create(context)
    private val _result: MutableStateFlow<String?> = MutableStateFlow("")
    val result: StateFlow<String?> = _result

    suspend fun updateInput(input: String?) {
        input?.let {
            withContext(dispatchers.io) {
                val spanned = markwon.toMarkdown(input)
                _result.update { spanned.toString() }
            }
        }
    }
}