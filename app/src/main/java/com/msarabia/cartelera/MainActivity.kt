package com.msarabia.cartelera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msarabia.cartelera.databinding.ActivityMainBinding
import com.msarabia.cartelera.fragments.ListVideoFragment
import com.msarabia.cartelera.helpers.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Cartelera)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        generateMoviesSections()
        generateTvShowSections()
    }

    private fun generateMoviesSections() {
        //Sections
        // Movies Sections
        val categories = arrayOf( CATEGORY_UPCOMING,CATEGORY_POPULAR, CATEGORY_TOP)

        val ftransaction = supportFragmentManager.beginTransaction()
        for(category in categories) {
            val f = ListVideoFragment(TYPE_MOVIES,category)
            ftransaction.add(R.id.sectionsMoviesContainer,f,TYPE_MOVIES+category)
        }

        ftransaction.commit()


    }

    private fun generateTvShowSections() {
        //Sections
        // TV shows Sections
        val categories = arrayOf( CATEGORY_POPULAR, CATEGORY_TOP)

        val ftransaction = supportFragmentManager.beginTransaction()
        for(category in categories) {
            val f = ListVideoFragment(TYPE_TVSHOW,category)
            ftransaction.add(R.id.sectionsTvShowContainer,f, TYPE_TVSHOW+category)
        }

        ftransaction.commit()


    }

}