package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.adapter.MyAdapter
import com.example.retrofit.network.repository.Repository
import com.example.retrofit.viewmodel.MainViewModel
import com.example.retrofit.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.adapter = myAdapter
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository = repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getPost("X-Code find")
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body().toString())
                Log.d("Response", response.code().toString())
                Log.d("Response", response.headers().toString())
            }
        })
//        val option: HashMap<String, String> = HashMap()
//        option["_sort"] = "id"
//        option["order"] = "abc"
//
//        viewModel.getCustomPost2(userId = 2, options = option)
//        viewModel.myCustomPost2.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                response.body()?.let { myAdapter.setData(it) }
//            } else {
//                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
//            }
//        })

//        val myPost = Post(2, 1, "Rahash", "lesson retrofit")
//        viewModel.pushPost2(myPost)
//        viewModel.myResponse.observe(this, Observer { responses ->
//            if (responses.isSuccessful) {
//                Log.d("Response", responses.body().toString())
//                Log.d("Response", responses.code().toString())
//                Log.d("Response", responses.message())
//            } else {
//                Toast.makeText(this, responses.code(), Toast.LENGTH_SHORT).show()
//            }
//        })

    }

}