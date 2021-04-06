package com.veronica.idn.cityweather.helper

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

fun DateCorverter(): String {
    val date = Calendar.getInstance().time
    val converter = SimpleDateFormat("EEE, d MMM yyyy",
        Locale("in"))
    val convertedDate = converter.format(date)
    return convertedDate
}
fun DayConverter(time : Long) : String{
    val converter = SimpleDateFormat("EEE, d MMM, yyyy hh:mm a")
    val convertedDay = converter.format(Date(time*1000))
    return convertedDay
}

fun TimeConverter(time: Long) : String {
    val converter = SimpleDateFormat("hh:mm a")
    val convertedTime = converter.format(Date(time*1000))
    return  convertedTime
}

@BindingAdapter("android : dayConverter")
fun convertToDay(view: TextView, value: Long){
    val converter = SimpleDateFormat("EEE, d MM yyyy hh:mmm a")
    val convertedDay = converter.format(Date(value*1000))
    view.text = convertedDay
}

@BindingAdapter("android:converterInt")
fun convertToInt(view: TextView, value: Double){
    val valueInt = value.toInt()
    val valueString = valueInt.toString()
    view.text = valueString
}

