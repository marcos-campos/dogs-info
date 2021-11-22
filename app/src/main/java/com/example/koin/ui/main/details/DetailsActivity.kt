package com.example.koin.ui.main.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.koin.R
import com.example.koin.model.BreedsResponse

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val info = intent.extras
        val dataDogs = info?.getSerializable ("data") as BreedsResponse

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_details, DetailsFragment.newInstance(dataDogs))
                .commitNow()
        }
    }
}