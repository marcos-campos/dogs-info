package com.example.koin.ui.main.main

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.example.koin.R
import com.example.koin.model.BreedsResponse
import com.example.koin.ui.main.details.DetailsActivity
import com.squareup.picasso.Picasso

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var dog: BreedsResponse
    val imageDog by lazy { view?.findViewById<ImageView>(R.id.main_iv) }
    val btnDeslike by lazy { view?.findViewById<Button>(R.id.main_btn_deslike) }
    val btnLike by lazy { view?.findViewById<Button>(R.id.main_btn_like) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setViewModel()
        getDog()
        setClicks()
    }

    fun setViewModel(){
        viewModel.dogsLiveData.observe(viewLifecycleOwner, Observer {
            Picasso.with(context).load(it[0].url).into(imageDog)
            dog = it[0]
        })
    }

    fun getDog(){
        viewModel.getListDogs()
    }

    fun setClicks(){
        btnLike?.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("data", dog)
            startActivity(intent)
        }

        btnDeslike?.setOnClickListener {
            getDog()
        }
    }
}