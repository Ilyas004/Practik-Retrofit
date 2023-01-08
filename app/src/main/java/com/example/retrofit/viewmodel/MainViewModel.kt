package com.example.retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.Post
import com.example.retrofit.network.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPost: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPost2: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(auth: String) {
        viewModelScope.launch {
            myResponse.value = repository.getPost(auth)
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            myResponse2.value = repository.getPost2(number)
        }
    }

    fun getCustomPost(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            myCustomPost.value = repository.getCustomPost(userId, sort, order)
        }
    }

    fun getCustomPost2(userId: Int, options: Map<String, String>) {
        viewModelScope.launch {
            myCustomPost2.value = repository.getCustomPost2(userId, options)
        }
    }

    fun pushPost(post: Post) {
        viewModelScope.launch {
            myResponse.value = repository.pushPost(post = post)
        }
    }

    fun pushPost2(post: Post) {
        viewModelScope.launch {
            myResponse.value = repository.pushPost(post = post)
        }
    }

}