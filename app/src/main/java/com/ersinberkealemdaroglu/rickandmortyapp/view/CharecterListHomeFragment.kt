package com.ersinberkealemdaroglu.rickandmortyapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ersinberkealemdaroglu.rickandmortyapp.R
import com.ersinberkealemdaroglu.rickandmortyapp.adapter.MovieAdapter
import com.ersinberkealemdaroglu.rickandmortyapp.databinding.FragmentCharecterListHomeBinding
import com.ersinberkealemdaroglu.rickandmortyapp.model.MovieModel
import com.ersinberkealemdaroglu.rickandmortyapp.service.RickApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharecterListHomeFragment : Fragment() {
    private lateinit var binding: FragmentCharecterListHomeBinding
    private var movieModel = ArrayList<MovieModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_charecter_list_home, container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list()
    }

    private fun list() {

        RickApi.retrofitService.getProperties().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>,
            ) {
                response.body()?.let { responseList ->
                    movieModel = ArrayList(responseList)
                    val movieAdapter = MovieAdapter(ArrayList(responseList))

                    val gridLayoutManager = GridLayoutManager(context, 2)
                    binding.apply {
                        recyclerView.layoutManager = gridLayoutManager
                        setVariable(BR.adapter, movieAdapter)
                    }

                }
            }
            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                println(t.message)
            }

        })
    }

}