package com.example.koin.ui.main.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koin.model.BreedsResponse
import com.example.koin.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val dogsLiveData = MutableLiveData<List<BreedsResponse>>()
    val repository = RepositoryApi()

    fun getListDogs(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.getDogs().let {
                dogsLiveData.postValue(it)
            }
        }
    }
}