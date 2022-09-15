package com.ersinberkealemdaroglu.rickandmortyapp.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ersinberkealemdaroglu.rickandmortyapp.databinding.ItemRowBinding
import com.ersinberkealemdaroglu.rickandmortyapp.model.MovieModel
import com.ersinberkealemdaroglu.rickandmortyapp.view.CharecterListHomeFragmentDirections

class AdapterViewHolder(
    private val movieDataBinding : ViewDataBinding
) : RecyclerView.ViewHolder(movieDataBinding.root) {
    fun onBind(movieModel: MovieModel){
        val binding = movieDataBinding as ItemRowBinding

        binding.apply {
            setVariable(BR.movieList, movieModel)

            imageView.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(CharecterListHomeFragmentDirections.actionCharecterListHomeFragmentToDetailFragment(movieModel))
            }
        }
    }
}