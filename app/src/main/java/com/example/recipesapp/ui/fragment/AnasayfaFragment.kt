package com.example.recipesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipesapp.R
import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.databinding.FragmentAnasayfaBinding
import com.example.recipesapp.ui.adapter.TariflerAdapter


class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {

private lateinit var tasarim:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        tasarim = FragmentAnasayfaBinding.inflate(inflater,container,false)

        tasarim.toolbarAnasayfa.title = "Tarifler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())

        val tariflerListesi = ArrayList<Tarifler>()
        val k1 = Tarifler(1,"Sarma","Sarmak prinç ve üzüm yapragı ile yapılır.")
        val k2 = Tarifler(2,"dolma","Sarmak prinç ve üzüm yapragı ile yapılır.")
        val k3 = Tarifler(3,"Mercimek","Sarmak prinç ve üzüm yapragı ile yapılır.")
        val k4 = Tarifler(4,"Patlican","Sarmak prinç ve üzüm yapragı ile yapılır.")
        val k5 = Tarifler(5,"Kabak","Sarmak prinç ve üzüm yapragı ile yapılır.")
        val k6 = Tarifler(6,"Makarna","Sarmak prinç ve üzüm yapragı ile yapılır.")
        val k7 = Tarifler(7,"Pizza","Sarmak prinç ve üzüm yapragı ile yapılır.")
        val k8 = Tarifler(8,"Melemen","Sarmak prinç ve üzüm yapragı ile yapılır.")

        tariflerListesi.add(k1)
        tariflerListesi.add(k2)
        tariflerListesi.add(k3)
        tariflerListesi.add(k4)
        tariflerListesi.add(k5)
        tariflerListesi.add(k6)
        tariflerListesi.add(k7)
        tariflerListesi.add(k8)

        val adapter = TariflerAdapter(requireContext(),tariflerListesi)
        tasarim.rv.adapter = adapter



        tasarim.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.tarifKayitGecis)
        }

        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView //Sen Search özelliğine sahip bir actionsun  diyoruz
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
           return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return tasarim.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {//Entere bastığımız metod da budur.
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {//Her karakter girdiğimizde çalışan fonksiyon
        ara(newText)
        return true
    }


    fun ara(aramaKelimesi : String){
        Log.e("Kisi Ara",aramaKelimesi)
    }


}