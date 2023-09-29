package com.example.recipesapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.recipesapp.data.entity.CRUDCevap
import com.example.recipesapp.data.entity.Detay
import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.data.entity.TariflerCevap
import com.example.recipesapp.retrofit.TariflerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TariflerDaRepository(var tdao: TariflerDao) {

    var tariflerListesi: MutableLiveData<List<Tarifler>>

    init {
        tariflerListesi = MutableLiveData()
    }

    fun tarifleriGetir(): MutableLiveData<List<Tarifler>> {
        return tariflerListesi
    }

    fun tarifKayit(request: Tarifler) {
        tdao.tarifEkleme(request).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {


                tumTariflerAl()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

            }

        })
    }


    fun tarifDetay(
        id: Int,
        result: (Detay?) -> Unit
    ) {
        tdao.tarifDetay(id).enqueue(object : Callback<Detay> {
            override fun onResponse(call: Call<Detay>, response: Response<Detay>) {
                result.invoke(response.body())


            }

            override fun onFailure(call: Call<Detay>, t: Throwable) {
                result.invoke(null)
            }

        })
    }


    fun tarifGuncelle(request: Tarifler) {
        // API'ye tarif güncelleme isteği yapılır
        tdao.tarifGuncelle(request).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                Log.e("dönüyorr","ddddddddddd")
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

            }
        })
    }

    fun tarifAra(aramaKelimesi: String) {
        tdao.tarifAra(aramaKelimesi).enqueue(object : Callback<TariflerCevap> {
            override fun onResponse(call: Call<TariflerCevap>, response: Response<TariflerCevap>) {
                val liste = response.body()!!.tarifler
                if (liste != null)
                    tariflerListesi.value = liste
            }

            override fun onFailure(call: Call<TariflerCevap>, t: Throwable) {

            }

        })
    }

    fun tumTariflerAl() {
        tdao.tumTarifler().enqueue(object : Callback<TariflerCevap> {
            override fun onResponse(call: Call<TariflerCevap>?, response: Response<TariflerCevap>) {
                val liste = response.body()!!.tarifler
                tariflerListesi.value = liste
            }

            override fun onFailure(call: Call<TariflerCevap>, t: Throwable) {

            }

        })
    }


}