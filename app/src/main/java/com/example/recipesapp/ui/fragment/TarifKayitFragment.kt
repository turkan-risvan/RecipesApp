package com.example.recipesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentTarifDetayBinding
import com.example.recipesapp.databinding.FragmentTarifKayitBinding


class TarifKayitFragment : Fragment() {
    private lateinit var tasarim : FragmentTarifKayitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = FragmentTarifKayitBinding.inflate(inflater, container, false)

        tasarim.toolbarTarifKayit.title = "Tarif Kayıt"


        tasarim.buttonKaydet.setOnClickListener {
            val name = tasarim.editTextTarifAd.text.toString()
            val id = tasarim.editTextTarifNo.text.toString()

         buttonKaydet(name, id)
        }
 return  tasarim.root
    }
    fun buttonKaydet(name:String, id :String){
        Log.e("Tarif Kayıt","$id - $name ")
}


}