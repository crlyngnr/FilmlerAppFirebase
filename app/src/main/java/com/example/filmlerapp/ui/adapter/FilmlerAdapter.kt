package com.example.filmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmlerapp.R
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.CardTasarimBinding
import com.example.filmlerapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext : Context, var filmlerListesi : List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.FilmViewHolder>()  {

    inner class FilmViewHolder(var tasarimBinding: CardTasarimBinding) : RecyclerView.ViewHolder(tasarimBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_tasarim,parent,false)
        return FilmViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmlerListesi.get(position)
        val t = holder.tasarimBinding
        val url = "http:kasimadalan.pe.hu/filmler_yeni/resimler/${film.resim}"
        Glide.with(mContext).load(url).override(500,750).into(t.imageView)
        t.filmNesnesi = film
        t.btnSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad}  sepete eklendi.",Snackbar.LENGTH_SHORT).show()
        }
        t.cardFilm.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

}