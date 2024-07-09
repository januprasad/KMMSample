package com.example.todoapp.android.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.ProductsApi
import com.example.todoapp.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private var _requestState: MutableState<RequestState> = mutableStateOf(RequestState.Idle)
    val requestState: State<RequestState> = _requestState
    init {
        viewModelScope.launch(Dispatchers.IO){
            ProductsApi().fetchProducts(limit = 3).collectLatest {
                _requestState.value = it
            }
        }
    }
}