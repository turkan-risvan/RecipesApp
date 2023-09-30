package com.example.recipesapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecisYap(id:Int,it: View){
    findNavController(it).navigate(id)
}

fun Navigation.gecisYap(it:View,id:NavDirections){
    findNavController(it).navigate(id)
}

fun Navigation.anasayfaGecisYap(it:View,id:NavDirections){
    findNavController(it).navigate(id)
}
