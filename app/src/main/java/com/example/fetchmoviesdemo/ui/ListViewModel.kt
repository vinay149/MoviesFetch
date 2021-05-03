package com.example.fetchmoviesdemo.ui

import android.text.BoringLayout
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchmoviesdemo.model.Detailtem
import com.example.fetchmoviesdemo.model.MovieItem
import com.example.fetchmoviesdemo.service.SerachApi
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class ListViewModel : ViewModel(){
    val moviesList:MutableLiveData<List<MovieItem>> = MutableLiveData();
    val openDetailsPage:MutableLiveData<Boolean> = MutableLiveData();
    val detailsPageData:MutableLiveData<MovieItem> = MutableLiveData();
    init {
       getTheMoviesList()
    }

    private  fun getTheMoviesList(){
        viewModelScope.launch {
            try {
                val response = SerachApi.service.getMovies().Search
                Log.d("ResponseData::","Data::"+Gson().toJson(response));
                moviesList.value = response;
            }catch (e:Exception){
                Log.d("ResponseData::","Data::"+e);
            }
        }
    }

    fun itemClicked(item: MovieItem){
        detailsPageData.value = item;
        openDetailsPage.value = true;
        Log.d("ItemClicked::","Data"+Gson().toJson(item));
    }

}