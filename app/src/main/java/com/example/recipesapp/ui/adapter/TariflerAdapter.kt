package com.example.recipesapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesapp.R

import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.databinding.CardTasarimBinding
import com.example.recipesapp.ui.fragment.AnasayfaFragmentDirections


class TariflerAdapter(var mContext:Context,var tarifListesi:List<Tarifler>) :RecyclerView.Adapter<TariflerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){

        var tasarim : CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {//ViewBinding kurulumunu yapacağımız yer
     val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {//RecyclerView de kaç tane ekleyeceğimi soruyor.
      return tarifListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {//RecyclerView işlemlerimizi yapacağız.
        val tarif = tarifListesi.get(position)

        val t = holder.tasarim

        t.textViewTarifBilgi.text = "${tarif.name} - ${tarif.id} - ${tarif.description}"

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.tarifDetayGecis(tarif = tarif)
            Navigation.findNavController(it).navigate(gecis)
        }

///Burası çalışmıyor icona tıklayınca
        t.guncelleButton.setOnClickListener {
            val gecis1 = AnasayfaFragmentDirections.tarifGuncelleGecis(tarif = tarif)
            Navigation.findNavController(it).navigate(gecis1)


        }
    }
}