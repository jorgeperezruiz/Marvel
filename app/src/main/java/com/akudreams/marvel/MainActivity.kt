package com.akudreams.marvel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.akudreams.marvel.data.Comic
import com.akudreams.marvel.views.ComicsRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ComicsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        comicsRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProviders.of(this).get(ComicsViewModel::class.java)
        MarvelApplication.appComponent.inject(viewModel)
        viewModel.loadComics()
        viewModel.comics?.observe(this, Observer<List<Comic>> { comics: List<Comic>? ->
            comicsRecyclerView.adapter = ComicsRecyclerViewAdapter(comics!!)
        })
    }
}
