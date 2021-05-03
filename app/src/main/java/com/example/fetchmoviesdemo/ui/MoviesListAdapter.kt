package com.example.fetchmoviesdemo.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchmoviesdemo.databinding.MoviesItemBinding
import com.example.fetchmoviesdemo.model.MovieItem
import com.google.gson.Gson

class MoviesListAdapter(val viewModel: ListViewModel) : ListAdapter<MovieItem,MoviesListAdapter.ListViewHolder>(ListDiffUtill()){


    private lateinit var binding: MoviesItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflator = LayoutInflater.from(parent.context);
        binding = MoviesItemBinding.inflate(inflator,parent,false);
        binding.viewmodel = viewModel;
        return ListViewHolder(binding);

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dataItem = getItem(position);
        holder.itemView.setOnClickListener {
            Log.d("ItemClicked::","Data");
            binding.viewmodel?.itemClicked(dataItem)
        }
        holder.bind(dataItem);
    }

    class ListViewHolder(private val binding: MoviesItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:MovieItem){

            binding.item = item
        }
    }

    class ListDiffUtill : DiffUtil.ItemCallback<MovieItem>(){
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.imdbID == oldItem.imdbID;
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return  oldItem==newItem;
        }

    }



}