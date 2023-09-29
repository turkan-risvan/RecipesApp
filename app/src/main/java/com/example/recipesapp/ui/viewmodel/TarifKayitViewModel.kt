package com.example.recipesapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.data.repo.TariflerDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TarifKayitViewModel @Inject constructor(var trepo: TariflerDaRepository) : ViewModel() {


    fun kayit(request: Tarifler) {
        trepo.tarifKayit(request)

    }

}