package com.example.fetchmoviesdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fetchmoviesdemo.databinding.FragmentListBinding
import com.example.fetchmoviesdemo.ui.ListViewModel
import com.example.fetchmoviesdemo.ui.MoviesListAdapter

class ListFragment : Fragment() {


    private lateinit var listBinding:FragmentListBinding
    private lateinit var listViewModel:ListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        listBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false);
        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        val adapter =  MoviesListAdapter(listViewModel);

        listBinding.moviesList.adapter = adapter;
        listViewModel.moviesList.observe(viewLifecycleOwner, Observer {
             it?.let {moviesList->
                  adapter.submitList(moviesList)
             }
        })
        listViewModel.openDetailsPage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    val action = listViewModel.detailsPageData.value?.imdbID?.let { it1 ->
                        ListFragmentDirections.actionListFragmentToDetailsFragment(
                            it1
                        )
                    }
                    if (action != null) {
                        findNavController().navigate(action)
                    }
                }
            }
        })

        return listBinding.root;
    }

}