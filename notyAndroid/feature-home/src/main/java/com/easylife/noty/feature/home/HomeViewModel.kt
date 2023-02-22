package com.easylife.noty.feature.home

import androidx.lifecycle.viewModelScope
import com.easylife.noty.core.designsystem.base.BaseViewModel
import com.easylife.noty.data.entity.Note
import com.easylife.noty.data.entity.NoteUI
import com.easylife.noty.domain.GetNotesUseCase
import com.easylife.noty.utils.result.NotyResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 10.02.2023
 */
class HomeViewModel(
    private val getNotesUseCase: GetNotesUseCase
) : BaseViewModel() {

    private val _notes: MutableStateFlow<List<NoteUI>> = MutableStateFlow(emptyList())
    val notes = _notes.asStateFlow()

    init {
        getNotes()
    }

    fun getNotes() {
        viewModelScope.launch {
            getNotesUseCase.execute(Unit).collect {result ->
                when (result) {
                    is NotyResult.Error -> _error.postValue(result.message)
                    is NotyResult.Success -> {
                        result.data?.let {list ->
                            _notes.update { list }
                        }
                    }
                }
            }
        }
    }

    fun onSearchTextChanged(searchText: String?) {

    }

    fun onNoteClicked(note: String) {

    }

}