package com.example.fetchmoviesdemo.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchmoviesdemo.model.Detailtem
import com.example.fetchmoviesdemo.service.SerachApi
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailsViewModel :ViewModel(){
    val detailsPageInfo:MutableLiveData<Detailtem> = MutableLiveData();
    var title:String = ""
    var year:String = ""
    var imdbID:String?=null

    private  fun getTheDetailsPage(){
        viewModelScope.launch {
            try {
                Log.d("GetingId::", "Data::" + imdbID)
                imdbID?.let {
                    Log.d("GetingId::", "Data::" + imdbID)
                    val response = SerachApi.detailsService.getDetailsPage(imdbID,"414edb62")
                    detailsPageInfo.value = response;
                    title = response.Title;
                    year = response.Year;
                    Log.d("DetailsPageResponse::", "Data::" + Gson().toJson(response))
                }
            }catch (e:Exception){
                Log.d("DetailsPageResponse::","Failed:"+e)
            }
        }
    }

    fun setTheImdbId(imdb:String?){
        imdbID = imdb;
        getTheDetailsPage()
    }
}