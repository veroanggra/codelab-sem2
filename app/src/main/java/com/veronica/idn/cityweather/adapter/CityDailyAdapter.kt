package com.veronica.idn.cityweather.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.veronica.idn.cityweather.model.DailyResponse
import com.veronica.idn.cityweather.model.ListItemd

class CityDailyAdapter(val cityDailyList : ArrayList<ListItemd>) : RecyclerView
.Adapter<CityDailyAdapter.CitydailyViewHolder>() {

    inner class CitydailyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityDailyAdapter.CitydailyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CityDailyAdapter.CitydailyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}