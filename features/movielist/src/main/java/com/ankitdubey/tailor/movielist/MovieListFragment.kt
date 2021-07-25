package com.ankitdubey.tailor.movielist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ankitdubey.tailor.core.ui.BaseFragment
import com.ankitdubey.tailor.movielist.databinding.FragmentMovieListBinding
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ankit Dubey on 17,July,2021
 */

@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding>() {

    private val viewModel by viewModels<MovieListViewModel>()
    lateinit var adapter: MovieListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeStates()
    }

    private fun observeStates() {
        viewModel.movieLiveData.observe(viewLifecycleOwner) {
            adapter.items = it
        }

        viewModel.categoryList.observe(viewLifecycleOwner) {
            it?.forEach { category ->
                val chip = Chip(requireContext())
                chip.text = category

                binding.cg.addView(chip)
            }
        }
    }

    private fun initViews() {
        adapter = MovieListAdapter(clickCallback = {
            navigateToDetails(it.id)
        })

        binding.rv.adapter = adapter
    }

    private fun navigateToDetails(movieId: Long) {
        val intent = Intent()
        intent.action = "tmdb://details"
        intent.putExtra(
            "id",
            movieId
        )
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMovieListBinding {
        return FragmentMovieListBinding.inflate(inflater)
    }
}