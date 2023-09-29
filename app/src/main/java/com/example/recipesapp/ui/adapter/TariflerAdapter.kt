package com.example.recipesapp.ui.adapter

import android.content.Context
import android.util.Log

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipesapp.data.entity.Detay

import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.databinding.CardTasarimBinding
import com.example.recipesapp.ui.fragment.AnasayfaFragmentDirections
import com.example.recipesapp.ui.viewmodel.AnasayfaViewModel
import com.example.recipesapp.util.gecisYap


class TariflerAdapter(
    var mContext: Context,
    var tarifListesi: List<Tarifler>,

    ) : RecyclerView.Adapter<TariflerAdapter.CardTasarimTutucu>() {
    lateinit var navController: NavController

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {

        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {//ViewBinding kurulumunu yapacağımız yer
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {//RecyclerView de kaç tane ekleyeceğimi soruyor.
        return tarifListesi.size
    }

    override fun onBindViewHolder(
        holder: CardTasarimTutucu,
        position: Int
    ) {//RecyclerView işlemlerimizi yapacağız.
        val tarif = tarifListesi.get(position)

        val t = holder.tasarim
        val context = t.root.context
        t.textViewTarifBilgi.text = "${tarif.name} - ${tarif.id}"




        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.tarifDetayGecis(tarif.id)
            Navigation.gecisYap(it, gecis)
            //val gecis =  Navigation.findNavController(it!!).navigate(R.id.tarifDetayGecis)


        }



        t.guncelleButton.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.tarifGuncelleGecis(tarif.id)
            Navigation.gecisYap(it, gecis)


        }

        Glide.with(context)
            .load("https://images.pexels.com/photos/2092897/pexels-photo-2092897.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load")
            .into(t.imageView5)
    }


}