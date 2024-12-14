package com.geeks.month5

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geeks.month5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView{

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val presenter = CounterPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachView(this)



        binding.apply {
            btnDecrement.setOnClickListener{
                presenter.onDecrement()
            }
            btnIncrement.setOnClickListener{
                presenter.onIncrementClick()
            }
        }
    }

    override fun showResult(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor(color: Int) {
       binding.tvResult.setTextColor(color)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}