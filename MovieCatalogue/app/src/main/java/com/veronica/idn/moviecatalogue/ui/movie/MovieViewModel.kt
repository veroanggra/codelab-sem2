package com.veronica.idn.moviecatalogue.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veronica.idn.moviecatalogue.BuildConfig
import com.veronica.idn.moviecatalogue.model.PopularResponse
import com.veronica.idn.moviecatalogue.model.ResultsItem
import com.veronica.idn.moviecatalogue.model.UpcomingResponse
import com.veronica.idn.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    fun init (page : Int){
        getPopularMovie(page)
    }

    //Data
    private val data = MutableLiveData<List<ResultsItem>>()

    private fun getPopularMovie(page: Int) {
     RetrofitConfig().getApiService().getPopular(BuildConfig.API_KEY, page)
         .enqueue(object: Callback<PopularResponse>{
             override fun onResponse(
                 call: Call<PopularResponse>,
                 response: Response<PopularResponse>
             ) {
                 if (response.isSuccessful){
                     val responseMovie : PopularResponse? = response.body()
                     data.postValue(responseMovie?.results!! as List<ResultsItem>?)
                 }
             }

             override fun onFailure(call: Call<PopularResponse>, t: Throwable) {
                 Log.e("failure", t.toString())
             }

         })
    }

    //get all attribut
    fun getData(): LiveData<List<ResultsItem>>{
        return data
    }

    // call page
    fun initUp(page:Int){
        getUpcoming(page)
    }

    private fun getUpcoming(page: Int) {
        RetrofitConfig().getApiService().getUpcoming(BuildConfig.API_KEY, page)
            .enqueue(object: Callback<UpcomingResponse>{
                override fun onResponse(
                    call: Call<UpcomingResponse>,
                    response: Response<UpcomingResponse>
                ) {
                    if (response.isSuccessful){
                        val responseUpcoming : UpcomingResponse? = response.body()
                        data.postValue(responseUpcoming?.results as List<ResultsItem>?)
                    }
                }

                override fun onFailure(call: Call<UpcomingResponse>, t: Throwable) {
                    Log.e ("Failure", t.toString())
                }
            })
    }

}