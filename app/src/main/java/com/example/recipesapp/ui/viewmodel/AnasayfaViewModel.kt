package com.example.recipesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.data.repo.TariflerDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var trepo: TariflerDaRepository) : ViewModel() {
    var tariflerListesi = MutableLiveData<List<Tarifler>>()

    init {
        tarifleriYukle()
        tariflerListesi = trepo.tarifleriGetir()
    }

    fun ara(aramaKelimesi: String) {
        trepo.tarifAra(aramaKelimesi)
    }

    fun tarifleriYukle() {
        trepo.tumTariflerAl()
    }

}