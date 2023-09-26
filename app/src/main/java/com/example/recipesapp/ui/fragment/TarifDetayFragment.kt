package com.example.recipesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs


import com.example.recipesapp.databinding.FragmentTarifDetayBinding


class TarifDetayFragment : Fragment() {
    private lateinit var tasarim : FragmentTarifDetayBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       tasarim = FragmentTarifDetayBinding.inflate(inflater,container,false)

        tasarim.toolbarTarifDetay.title = "Tarif Detay"


//Argümanları aldık
        val bundle: TarifDetayFragmentArgs by navArgs()
        val gelenTarif = bundle.tarif

        tasarim.textViewTarifAd.setText(gelenTarif.name)
        tasarim.textViewTarifYapilis .setText(gelenTarif.description)
       // tasarim.editTextTarifNo.setText(gelenTarif.id)



        return  tasarim.root
    }


}