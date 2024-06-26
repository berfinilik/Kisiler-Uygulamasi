package com.berfinilik.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.berfinilik.kisileruygulamasi.R
import com.berfinilik.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.berfinilik.kisileruygulamasi.databinding.FragmentKisiDetayBinding

class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false)

        binding.kisiDetayFragment=this
        binding.kisiDetayToolbarBaslik="Kişi Detay"

        //sayfa geçişi oldugunda edittext içinde ad ve tel görüntülencek sonra güncelle butonuna basıp en son alınan degerler alıncak
        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi=bundle.kisi
        binding.kisiNesnesi=gelenKisi


        return binding.root
    }

    fun buttonGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String) {
        Log.e("Kişi Güncelle","$kisi_id-$kisi_ad-$kisi_tel")
    }



}