package com.example.recipesapp.retrofit

import com.example.recipesapp.data.entity.CRUDCevap
import com.example.recipesapp.data.entity.Detay
import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.data.entity.TariflerCevap
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TariflerDao {

    @GET("get_recipes.php")
    fun tumTarifler(): Call<TariflerCevap>

    @GET("search_recipe.php")
    fun tarifAra(@Query("query") name: String): Call<TariflerCevap>

    @GET("get_recipe_detail.php")
    fun tarifDetay(@Query("id") id: Int): Call<Detay>

    @POST("add_recipe.php")
    fun tarifEkleme(@Body request: Tarifler): Call<CRUDCevap>

    @POST("update_recipe.php")
    fun tarifGuncelle(@Body request: Tarifler): Call<CRUDCevap>

}
