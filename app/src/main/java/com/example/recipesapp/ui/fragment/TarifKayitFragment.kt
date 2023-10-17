package com.example.recipesapp.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.databinding.FragmentTarifKayitBinding
import com.example.recipesapp.ui.viewmodel.TarifKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TarifKayitFragment : Fragment() {
    private lateinit var tasarim: FragmentTarifKayitBinding
    private lateinit var viewModel: TarifKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        tasarim = FragmentTarifKayitBinding.inflate(inflater, container, false)

        tasarim.toolbarTarifKayit.title = "Yemek Kayıt"

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarTarifKayit)

        val alert = AlertDialog.Builder(requireContext())
        tasarim.buttonKaydet.setOnClickListener {
            val name = tasarim.editTextTarifAd.text.toString()
            val description = tasarim.editTextTarifNo.text.toString()

            if (!name.equals("") && !description.equals("")) {
                alert.setMessage("${name.uppercase()} eklensin mi ?")
                alert.setPositiveButton("Evet") {dialog,which ->
                    val tarif = Tarifler(0, name, description)
                    buttonKaydet(tarif)

                    Toast.makeText(requireContext(), "${name.uppercase()} Eklendi", Toast.LENGTH_LONG)
                        .show()
                }
                alert.setNegativeButton("Hayır") {dialog,which ->
                    val tarif = Tarifler(0, name, description)
                    buttonKaydet(tarif)

                    Toast.makeText(requireContext(), "${name.uppercase()} Eklendi", Toast.LENGTH_LONG)
                        .show()
                }
              alert.show()

            }
            else{
                Toast.makeText(requireContext(),"Alanlar Boş Bırakılamaz!",Toast.LENGTH_LONG).show()
            }

        }
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TarifKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(request: Tarifler) {
        viewModel.kayit(request)
    }


}