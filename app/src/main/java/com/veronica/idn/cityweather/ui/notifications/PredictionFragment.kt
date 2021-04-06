package com.veronica.idn.cityweather.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.veronica.idn.cityweather.R

class PredictionFragment : Fragment() {

    private lateinit var predictionViewModel: PredictionViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        predictionViewModel =
                ViewModelProvider(this).get(PredictionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_prediction, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        predictionViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}