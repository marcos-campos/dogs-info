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
import com.example.koin.model.BreedsResponse
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

    private lateinit var dogLoadedOk: BreedsResponse

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setObservers()
        getDog()
        setClicks()
    }

    private fun setObservers() {
        viewModel.dogsLiveData.observe(viewLifecycleOwner, Observer {
            dogLoadedOk = it[0]
            Picasso.with(context).load(it[0].url).into(imageDog)
        })
    }

    private fun getDog() {
        viewModel.getListDogs()
    }

    private fun setClicks() {
        btnLike?.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("data", dogLoadedOk)
            startActivity(intent)
        }

        btnDeslike?.setOnClickListener {
            getDog()
        }
    }
}