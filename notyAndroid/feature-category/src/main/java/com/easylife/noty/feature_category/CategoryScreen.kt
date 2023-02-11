package com.easylife.noty.feature_category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.easylife.noty.core.designsystem.base.BaseScreen
import com.easylife.noty.core.designsystem.components.NotyTopBar
import com.easylife.noty.core.designsystem.components.category.CategoryList
import com.easylife.noty.core.designsystem.components.SearchTextField

/**
 * Created by erenalpaslan on 10.02.2023
 */
class CategoryScreen: BaseScreen<CategoryViewModel>() {
    @Composable
    override fun Screen() {
        Content()
    }

    @Composable
    fun Content() {
        Scaffold(
            topBar = {
                NotyTopBar(
                    title = "Categories",
                    divider = {
                        Divider(modifier = Modifier.padding(horizontal = 16.dp))
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                SearchTextField(
                    placeholder = {
                        Text(text = "Search categories...")
                    }
                ) {searchText ->
                    viewModel.onSearchTextChanged(searchText)
                }

                CategoryList {

                }
            }
        }
    }
}