package com.loranttoth.newsapp.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.loranttoth.newsapp.R
import com.loranttoth.newsapp.databinding.ActivityMainBinding
import com.loranttoth.newsapp.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var newsViewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as Injector).createNewsSubComponent().inject(this)

        newsViewModel = ViewModelProvider(this,factory)
            .get(MyViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter()
        binding.recyclerView.adapter = adapter
        displayNews()
    }

    private fun displayNews() {
        binding.newsProgressBar.visibility = View.VISIBLE
        val responseLiveData = newsViewModel.getNews("us")

        responseLiveData.observe(this, Observer{
            if (it !=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.newsProgressBar.visibility = View.GONE
            }else{
                binding.newsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.newsProgressBar.visibility = View.VISIBLE
        val response = newsViewModel.updateNews("us")
        response.observe(this, Observer {

            if (it!= null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.newsProgressBar.visibility = View.GONE
            }else{
                binding.newsProgressBar.visibility = View.GONE

            }
        })


    }


}