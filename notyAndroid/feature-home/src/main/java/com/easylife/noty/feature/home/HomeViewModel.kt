package com.easylife.noty.feature.home

import com.easylife.noty.core.designsystem.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by erenalpaslan on 10.02.2023
 */
@HiltViewModel
class HomeViewModel @Inject constructor(): BaseViewModel() {

    fun onSearchTextChanged(searchText: String?) {

    }

    fun onNoteClicked(note: String) {

    }

}