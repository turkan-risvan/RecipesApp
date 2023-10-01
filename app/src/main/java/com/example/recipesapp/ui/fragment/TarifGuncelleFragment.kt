package com.example.recipesapp.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.recipesapp.R
import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.databinding.FragmentTarifDetayBinding
import com.example.recipesapp.databinding.FragmentTarifGuncelleBinding
import com.example.recipesapp.ui.viewmodel.AnasayfaViewModel
import com.example.recipesapp.ui.viewmodel.TarifDetayViewModel
import com.example.recipesapp.ui.viewmodel.TarifGuncelleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TarifGuncelleFragment : Fragment() {
    private lateinit var tasarim: FragmentTarifGuncelleBinding
    private lateinit var viewModel: TarifGuncelleViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentTarifGuncelleBinding.inflate(inflater, container, false)

        tasarim.toolbarTarifGuncelle.title = "Tarif Güncelle"

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarTarifGuncelle)


        // ViewModel'i başlat
        viewModel = ViewModelProvider(this).get(TarifGuncelleViewModel::class.java)

        //Argümanları aldık
        val bundle: TarifGuncelleFragmentArgs by navArgs()
        val gelenTarif = bundle.detayTarif
        viewModel.getTarifDetay(gelenTarif)
        // ViewModel tarafından gönderilen verileri gözlemle
            viewModel.tarifDetayLiveData.observe(viewLifecycleOwner) { detay ->
            tasarim.editTextTarifAd.setText(detay.recipe.name)
            tasarim.textViewTarifYapilis.setText(detay.recipe.description)


        }
        val alert = AlertDialog.Builder(requireContext())
        tasarim.buttonGuncelle.setOnClickListener {
            val name = tasarim.editTextTarifAd.text.toString()
            val description = tasarim.textViewTarifYapilis.text.toString()


            if (!name.equals("") && !description.equals("")) {
                alert.setMessage("${name.uppercase()} Güncellensin mi?")
                alert.setPositiveButton("Evet"){dialog,which ->
                    val tarif = Tarifler(gelenTarif, name, description)
                    buttonGuncelle(tarif)
                    Toast.makeText(
                        requireContext(),
                        "${name.uppercase()} Güncellendi",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }else{
                alert.setNegativeButton("Hayır"){dialog,which ->
                    Toast.makeText(
                        requireContext(),
                        "Güncellenemedi!",
                        Toast.LENGTH_LONG
                    ).show()
                }
               alert.show()
            }
        }
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TarifGuncelleViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(request: Tarifler) {
       viewModel.getTarifGuncelle(request)
    }

}