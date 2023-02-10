package com.example.apicalls

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicalls.data.AppRepository
import com.example.apicalls.data.remote.GotApi
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"

enum class Weekday {MO, DIE, MI, DO, FR, SA, SO}

enum class ApiStatus { LOADING, ERROR, DONE }

class MainViewModel : ViewModel() {
    private val repository = AppRepository(GotApi)

    val characters = repository.characters

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
    get() = _loading

    init {
        loadCharacters()
    }

    private fun  loadCharacters() {
        viewModelScope.launch {
            try {
                _loading.value = ApiStatus.LOADING
                repository.loadCharacters()
                _loading.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.e("MainViewModel", "error loading charackters $e")
                _loading.value = ApiStatus.ERROR
            }
        }
    }
}
