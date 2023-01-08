package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.databinding.RecyclerViewBinding
import com.example.retrofit.model.Post

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = RecyclerViewBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_view, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvUserId.text = myList[position].userId.toString()
        holder.binding.tvId.text = myList[position].id.toString()
        holder.binding.tvTitle.text = myList[position].title
        holder.binding.tvBody.text = myList[position].body
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Post>) {
        myList = newList
        notifyDataSetChanged()
    }
}