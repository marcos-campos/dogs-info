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
    val breedFor by lazy { view?.findViewById<TextView>(R.id.details_tv_breed_for_response) }
    val breedGroup by lazy { view?.findViewById<TextView>(R.id.details_tv_breed_group_response) }
    val lifeSpan by lazy { view?.findViewById<TextView>(R.id.details_tv_life_span_response) }
    val temperament by lazy { view?.findViewById<TextView>(R.id.details_tv_temperament_response) }
    val image by lazy { view?.findViewById<ImageView>(R.id.details_iv) }

    val messageError: String = "info not found"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(infoDogs.breeds.isNotEmpty()){

            setTexts()

        } else {

            setMessageError()
        }

        setImage()
    }

    private fun setTexts(){
        title?.text = infoDogs.breeds[0].name
        breedFor?.text = infoDogs.breeds[0].bredFor
        breedGroup?.text = infoDogs.breeds[0].breedGroup
        lifeSpan?.text = infoDogs.breeds[0].lifeSpan
        temperament?.text = infoDogs.breeds[0].temperament
    }

    private fun setMessageError(){
        title?.text = messageError
        breedFor?.text = messageError
        breedGroup?.text = messageError
        lifeSpan?.text = messageError
        temperament?.text = messageError
    }

    private fun setImage(){
        Picasso.with(context).load(infoDogs.url).into(image)
    }
}