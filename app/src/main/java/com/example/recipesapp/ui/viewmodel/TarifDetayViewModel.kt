package com.example.recipesapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.data.entity.Detay
import com.example.recipesapp.data.repo.TariflerDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TarifDetayViewModel @Inject constructor(private val trepo: TariflerDaRepository) :
    ViewModel() {

    val tarifDetayLiveData: MutableLiveData<Detay> = MutableLiveData()

    fun getTarifDetay(id: Int) {
        viewModelScope.launch {
            try {
                trepo.tarifDetay(id) { detay ->
                    if (detay != null) {
                        tarifDetayLiveData.value = detay
                    } else {

                    }
                }


            } catch (e: Exception) {
                // Hata durumunu ele al
            }
        }
    }
}