package com.example.retrofit.network.repository

import com.example.retrofit.model.Post
import com.example.retrofit.network.api.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getPost(auth: String): Response<Post> {
        return RetrofitInstance.api.getPost(auth)
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId, sort, order)
    }

    suspend fun getCustomPost2(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost2(userId, options)
    }

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPost2(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost2(
            userId = post.userId,
            id = post.id,
            title = post.title,
            body = post.body
        )
    }
}