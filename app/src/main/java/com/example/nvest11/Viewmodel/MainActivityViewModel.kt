package com.example.nvest11.Viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nvest11.Data.Ecommodel
import com.example.nvest11.Retrofit.RetroInstance
import com.example.nvest11.Retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<Ecommodel>>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<List<Ecommodel>> {
        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.getprodcuctList()
        call.enqueue(object : Callback<List<Ecommodel>> {
            override fun onFailure(call: Call<List<Ecommodel>>, t: Throwable) {

                liveDataList.postValue(null)
            }

            override fun onResponse(

                call: Call<List<Ecommodel>>,
                response: Response<List<Ecommodel>>
            ) {

                liveDataList.postValue(response.body())

            }


        })


    }
}