package com.example.adaptador

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adaptador.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rvwNews.layoutManager = LinearLayoutManager(this)
        binding.rvwNews.adapter = NoticiaAdapter(getNews(),
            onNoticiaClicked = { noticia -> Toast.makeText(this, "Click en ${noticia.title}", Toast.LENGTH_SHORT).show()}")

    }
    fun getNews(): List<Noticia>{

        val noticias = mutableListOf<Noticia>()

        for (i in 1..50){
            noticias.add(Noticia("Noticia $i", "Descripción de la noticia $i"))
        }

        return noticias
            }
}