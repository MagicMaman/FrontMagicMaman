package com.example.magicmamanapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.repository.Repository
import androidx.lifecycle.Observer
import com.example.magicmamanapplication.adapters.MySommeilAdapter
import kotlinx.android.synthetic.main.activity_resume_sommeil.*

class ResumeSommeil : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    private val myAdapter by lazy { MySommeilAdapter() }
    lateinit var tvprenombebe: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_sommeil)
        setupRecyclerview()

        val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
        val savedString=sharedPreferences.getString("STRING_KEY", null)

        tvprenombebe=findViewById(R.id.textViewdisplaybabys)
        tvprenombebe.text="Nom Bebe: "+savedString


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.myCustomSommeil(5,"id", "desc")

        viewModel.myCustomSommeil.observe(this, Observer { response ->

            /*  if(response.isSuccessful){
                  textView2.text=response.body().toString()   //Mettre dans adapter: arrayList

              }*/

            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                //textView2.text=response.code().toString()
            }
        })

    }

    private fun setupRecyclerview() {
        recycleviewSommeil.adapter = myAdapter
        recycleviewSommeil.layoutManager = LinearLayoutManager(this)


    }

}
