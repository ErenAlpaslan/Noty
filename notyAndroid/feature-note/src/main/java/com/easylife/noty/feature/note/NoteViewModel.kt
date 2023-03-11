package com.easylife.noty.feature.note

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.easylife.noty.core.designsystem.base.BaseViewModel
import com.easylife.noty.core.navigation.NavigationKeys
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.data.entity.NoteUI
import com.easylife.noty.domain.AddNoteUseCase
import com.easylife.noty.domain.DeleteNoteUseCase
import com.easylife.noty.domain.GetNoteUseCase
import com.easylife.noty.utils.result.NotyResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 11.02.2023
 */
class NoteViewModel(
    private val notyNavigator: NotyNavigator,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val getNoteUseCase: GetNoteUseCase,
    private val savedStateHandle: SavedStateHandle
): BaseViewModel() {

    val uiState: MutableStateFlow<NoteUiState> = MutableStateFlow(NoteUiState())
    var noteUI: NoteUI? = null

    init {
        viewModelScope.launch {
            val id: String? = savedStateHandle[NavigationKeys.ID]
            getNote(id)
        }
    }

    private fun getNote(id: String?) {
        if (!id.isNullOrEmpty()) {
            viewModelScope.launch {
                getNoteUseCase.execute(GetNoteUseCase.Param(id)).collect {result ->
                    when(result) {
                        is NotyResult.Error -> _error.postValue(result.message)
                        is NotyResult.Success -> {
                            noteUI = result.data
                            uiState.update {
                                it.copy(
                                    title = noteUI?.title,
                                    content = noteUI?.content
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun onSaveClicked() {
        viewModelScope.launch {
            addNoteUseCase.execute(AddNoteUseCase.Param(
                uiState.value.title,
                uiState.value.content
            )).collect {result ->
               when(result) {
                   is NotyResult.Error -> _error.postValue(result.message)
                   is NotyResult.Success -> {
                       notyNavigator.navigateBackWithResult(
                           key = NavigationKeys.ENTRY_AFFECTED,
                           result = true
                       )
                   }
               }
            }
        }
    }

    fun onDeleteClicked() {
        viewModelScope.launch {
            noteUI?.let {
                deleteNoteUseCase.execute(DeleteNoteUseCase.Param(it)).collect {result ->
                    when(result) {
                        is NotyResult.Error -> _error.postValue(result.message)
                        is NotyResult.Success -> {
                            notyNavigator.navigateBackWithResult(
                                key = NavigationKeys.ENTRY_AFFECTED,
                                result = true
                            )
                        }
                    }
                }
            }
        }
    }

    fun onTitleChanged(title: String?) {
        uiState.update {
            it.copy(title = title)
        }
    }

    fun onContentChanged(content: String?) {
        uiState.update {
            it.copy(content = content)
        }
    }

}