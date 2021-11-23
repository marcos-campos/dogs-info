package com.example.koin.ui.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.koin.R
import com.example.koin.model.BreedsResponse
import com.squareup.picasso.Picasso

class DetailsFragment(val infoDogs: BreedsResponse)  : Fragment() {

    companion object {
        fun newInstance(info: BreedsResponse) = DetailsFragment(info)
    }

    val title by lazy { view?.findViewById<TextView>(R.id.details_tv) }
    val image by lazy { view?.findViewById<ImageView>(R.id.details_iv) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (infoDogs.breeds.isNotEmpty()) {
            title?.text = infoDogs.breeds[0].name
        } else {
            title?.text = "nao tem"
        }

        Picasso.with(context).load(infoDogs.url).into(image)

    }
}