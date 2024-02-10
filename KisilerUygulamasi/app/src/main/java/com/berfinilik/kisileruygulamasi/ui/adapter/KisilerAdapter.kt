package com.berfinilik.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.berfinilik.kisileruygulamasi.data.entity.Kisiler
import com.berfinilik.kisileruygulamasi.databinding.CardTasarimBinding
import com.berfinilik.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.berfinilik.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

//ilki context nesnesi ikincisi veri kümesi

class KisilerAdapter(var mContext: Context,var kisilerListesi:List<Kisiler>)
    :RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        //amaç card tasarıma erişmek(viewbinding yaptık)

        val binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)


    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        //karta tıklama,karta yazdırma,kart üzerindeki ıtema tıklama gibi kartla ilgili şeyler burada
        val kisi=kisilerListesi.get(position)
        val t=holder.tasarim

        t.textViewKisiAd.text=kisi.kisi_ad
        t.textViewKisiTel.text=kisi.kisi_tel

        t.cardViewSatir.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.kisiDetayGecis(kisi=kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    sil(kisi.kisi_id)
                }
                .show()
        }

    }

    override fun getItemCount(): Int {
        //kaç tane ıtem var

        return kisilerListesi.size
    }

    fun sil(kisi_id:Int) {
        Log.e("Kişi sil",kisi_id.toString())

    }

}