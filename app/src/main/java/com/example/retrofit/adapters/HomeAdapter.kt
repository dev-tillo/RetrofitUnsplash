package com.example.retrofit.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.classes.Result
import com.example.retrofit.classes.UnSplashUsers
import com.example.retrofit.databinding.ItemImageBinding
import com.squareup.picasso.Picasso

class HomeAdapter(var context: Context, var listener: onItemClicked) :
    ListAdapter<Result, HomeAdapter.Vh>(MyDiffUtil()) {

    class MyDiffUtil : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result,
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val item = getItem(position)
        holder.itemImageBinding.apply {

//            Picasso.get().load(item.urls.regular)
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(image)
            Glide.with(context).load(item.urls.regular).into(image)


            image.setOnClickListener {
                listener.onCliked(item.urls.regular, position)
            }
        }
    }

    inner class Vh(var itemImageBinding: ItemImageBinding) :
        RecyclerView.ViewHolder(itemImageBinding.root) {
    }

    interface onItemClicked {
        fun onCliked(url: String, position: Int)
    }
}