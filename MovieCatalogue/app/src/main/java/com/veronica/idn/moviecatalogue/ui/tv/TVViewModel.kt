package com.veronica.idn.moviecatalogue.ui.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veronica.idn.moviecatalogue.BuildConfig
import com.veronica.idn.moviecatalogue.model.tv.TVPopularResponse
import com.veronica.idn.moviecatalogue.model.tv.TvPopularItemResponse
import com.veronica.idn.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TVViewModel : ViewModel() {
    fun initPopularTv(page: Int) {
        getPopularTv(page)
    }

    private val dataPopularTv = MutableLiveData<List<TvPopularItemResponse>>()

    private fun getPopularTv(page: Int) {
        RetrofitConfig().getApiService().getTvPopular(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<TVPopularResponse> {
                override fun onResponse(
                    call: Call<TVPopularResponse>,
                    response: Response<TVPopularResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseTVPopular: TVPopularResponse? = response.body()
                        dataPopularTv.postValue(responseTVPopular?.results)
                    }
                }

                override fun onFailure(call: Call<TVPopularResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }

    fun getTvPopularData(): LiveData<List<TvPopularItemResponse>> {
        return dataPopularTv
    }

}