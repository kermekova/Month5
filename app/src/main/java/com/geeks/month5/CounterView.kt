package com.geeks.month5

import android.graphics.Color

interface CounterView {

    fun showResult(count:Int)
    fun showToast(message: String)
    fun changeTextColor(color: Int)

}