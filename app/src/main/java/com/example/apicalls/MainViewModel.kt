package com.example.apicalls

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicalls.data.AppRepository
import com.example.apicalls.data.remote.GotApi
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    private val repository = AppRepository(GotApi)

    val characters = repository.characters

    init {
        loadCharacters()
    }

    private fun  loadCharacters() {
        viewModelScope.launch {
            repository.loadCharacters()
        }
    }
}
