package com.example.fetchmoviesdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fetchmoviesdemo.databinding.FragmentDetailsBinding
import com.example.fetchmoviesdemo.databinding.FragmentListBinding
import com.example.fetchmoviesdemo.ui.DetailsViewModel

class DetailsFragment : Fragment() {


    private  lateinit var binding:FragmentDetailsBinding
    protected lateinit var viewmodel:DetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false);
        val imdb = arguments?.let {
            DetailsFragmentArgs.fromBundle(it).imdbId
        }
        Log.d("getTheImdbRating","Rating::"+imdb);
        viewmodel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        binding.viewModel  = viewmodel;
        viewmodel.setTheImdbId(imdb);
        viewmodel.detailsPageInfo.observe(viewLifecycleOwner, Observer {
            binding.title.text = it.Title;
            binding.year.text = it.Year;
            binding.actors.text = it.Actors;
        })
        return binding.root;
    }


}