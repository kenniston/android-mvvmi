package br.com.dynamiclight.androidmvvmi.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dynamiclight.androidmvvmi.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
