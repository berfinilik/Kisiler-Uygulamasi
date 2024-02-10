package com.berfinilik.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.berfinilik.kisileruygulamasi.R
import com.berfinilik.kisileruygulamasi.data.entity.Kisiler
import com.berfinilik.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.berfinilik.kisileruygulamasi.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        binding.anasayfaFragment=this
        binding.anasayfaToolbarBaslik="Kişiler"

        val kisilerListesi=ArrayList<Kisiler>()
        val k1=Kisiler(1,"Ahmet","1111")
        val k2=Kisiler(2,"Zeynep","2222")
        val k3=Kisiler(3,"Beyza","3333")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        //adapterdan nesne oluşturalım
        val kisilerAdapter=KisilerAdapter(requireContext(),kisilerListesi)
        binding.kisilerAdapter=kisilerAdapter

        binding.searchView.setOnQueryTextListener(object:OnQueryTextListener{
            //harf girdikçe sildikçe sonuç gelecek fonksiyon
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true

            }
            //arama ikonuna basınca sonuç getirecek fonksiyon
            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })



        return binding.root
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)


    }
    fun ara(aramaKelimesi:String){
        Log.e("Kisi",aramaKelimesi)
    }


}