package com.example.apicalls

import android.util.Log
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
            try {
                repository.loadCharacters()
            } catch (e: Exception) {
                Log.e("MainViewModel", "error loading charackters $e")
            }
        }
    }
}
