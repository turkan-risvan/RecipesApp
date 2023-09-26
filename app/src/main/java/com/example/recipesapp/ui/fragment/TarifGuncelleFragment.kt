package com.example.recipesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentTarifDetayBinding
import com.example.recipesapp.databinding.FragmentTarifGuncelleBinding


class TarifGuncelleFragment : Fragment() {
    private lateinit var tasarim : FragmentTarifGuncelleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentTarifGuncelleBinding.inflate(inflater,container,false)

        tasarim.toolbarTarifDetay.title = "Tarif Güncelle"

        //Argümanları aldık
        val bundle: TarifDetayFragmentArgs by navArgs()
        val gelenTarif = bundle.tarif

        tasarim.editTextTarifAd.setText(gelenTarif.name)
        tasarim.editTextTarifDetay.setText(gelenTarif.description)
        // tasarim.editTextTarifNo.setText(gelenTarif.id)


        tasarim.buttonGuncelle.setOnClickListener {
            val name = tasarim.editTextTarifAd.text.toString()
            // val id = tasarim.editTextTarifNo.text.toString()
            val description = tasarim.editTextTarifDetay.text.toString()


            guncelle(gelenTarif.id,name,description)
        }
        return  tasarim.root
    }

    fun guncelle(id : Int,name:String,description:String){

        Log.e("Tarif Güncelle","$id - $name - $description")

    }
}