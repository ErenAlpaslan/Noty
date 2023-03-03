package com.easylife.noty.feature.note

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.easylife.noty.core.designsystem.base.BaseViewModel
import com.easylife.noty.domain.AddNoteUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 11.02.2023
 */
class NoteViewModel(
    private val addNoteUseCase: AddNoteUseCase
): BaseViewModel() {

    private var title: String? = ""
    private var content: String? = ""

    fun onSaveClicked() {
        viewModelScope.launch {
            addNoteUseCase.execute(AddNoteUseCase.Param(title, content)).collect {
                Log.d("NoteControl", "=> $it")
            }
        }
    }

    fun onRedoClicked() {

    }

    fun onUndoClicked() {

    }

    fun onTitleChanged(title: String?) {
        this.title = title
    }

    fun onContentChanged(content: String?) {
        this.content = content
    }

}