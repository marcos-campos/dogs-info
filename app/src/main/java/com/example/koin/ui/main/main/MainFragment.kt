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
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.koin.R
import com.example.koin.ui.main.details.DetailsActivity
import com.squareup.picasso.Picasso

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    val imageDog by lazy { view?.findViewById<ImageView>(R.id.main_iv) }
    val btnDeslike by lazy { view?.findViewById<Button>(R.id.main_btn_deslike) }
    val btnLike by lazy { view?.findViewById<Button>(R.id.main_btn_like) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setDog()
        like()
        deslike()
    }

    fun setDog(){
        viewModel.getListDogs()
        viewModel.dogsLiveData.observe(viewLifecycleOwner, Observer {
            Picasso.with(context).load(it[0].url).into(imageDog)
        })
    }

    fun like(){
        btnLike?.setOnClickListener {
            viewModel.dogsLiveData.observe(viewLifecycleOwner, Observer {listBreeds ->
                val intent = Intent(context, DetailsActivity::class.java)
                val list = listBreeds[0]
                intent.putExtra("data", list)
                startActivity(intent)
            })
        }
    }

    fun deslike(){
        btnDeslike?.setOnClickListener {
            viewModel.getListDogs()
            viewModel.dogsLiveData.observe(viewLifecycleOwner, Observer {
                Picasso.with(context).load(it[0].url).into(imageDog)
            })
        }
    }
}