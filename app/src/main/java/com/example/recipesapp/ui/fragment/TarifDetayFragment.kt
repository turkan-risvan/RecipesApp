package com.example.recipesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.recipesapp.R


import com.example.recipesapp.databinding.FragmentTarifDetayBinding

import com.example.recipesapp.ui.viewmodel.TarifDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TarifDetayFragment : Fragment() {

    private lateinit var tasarim: FragmentTarifDetayBinding
    private lateinit var viewModel: TarifDetayViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentTarifDetayBinding.inflate(inflater, container, false)



        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarTarifDetay)


        // ViewModel'i başlat
         viewModel = ViewModelProvider(this).get(TarifDetayViewModel::class.java)

        // ViewModel'den API'den verileri alma işlemi
        val bundle: TarifDetayFragmentArgs by navArgs()
        val gelenTarifId = bundle.detayTarif
         viewModel.getTarifDetay(gelenTarifId)

        // ViewModel tarafından gönderilen verileri gözlemle
            viewModel.tarifDetayLiveData.observe(viewLifecycleOwner) { detay ->
            tasarim.textViewTarifAd.title = detay.recipe.name
            tasarim.textViewTarifYapilis.text = detay.recipe.description



        }


        return tasarim.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fragmentImageView = view.findViewById<ImageView>(R.id.imageView3)
        if (fragmentImageView != null) {
            // ImageView'e resmi Glide ile yükleme
            val imageUrl =
                "https://images.pexels.com/photos/1213710/pexels-photo-1213710.jpeg?auto=compress&cs=tinysrgb&w=1600" // Resmin URL'si
            Glide.with(this)
                .load(imageUrl)
                .into(fragmentImageView)
        }




    }



}
