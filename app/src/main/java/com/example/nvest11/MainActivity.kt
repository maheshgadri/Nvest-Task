package com.example.nvest11

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nvest11.Adapter.ProdcutAdapter
import com.example.nvest11.Data.Ecommodel
import com.example.nvest11.Viewmodel.MainActivityViewModel
import com.example.nvest11.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    lateinit var recyclerAdapter: ProdcutAdapter


    val productList= ArrayList<Ecommodel>()
    val displayList=ArrayList<Ecommodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

       val  editTextsearch= findViewById(R.id.et_search) as EditText
        initRecyclerView()
        initViewModel()




        editTextsearch.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {
                filterli(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }

    private fun filterli(textu: String) {

        var templist: ArrayList<Ecommodel> = ArrayList()
//        val filteredNames = ArrayList<Ecommodel>()
//        productList?.filterTo(filteredNames){
//            it.title.toUpperCase().contains(textu.toUpperCase())
//        }
//
        for (Ecommodel  in productList ) {

            if (Ecommodel.title.contains(textu.toLowerCase())) {

                templist.add(Ecommodel)

               recyclerAdapter.filterList(Ecommodel)

            }}}









    private fun initRecyclerView() {
        productRecyclerview.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = ProdcutAdapter(this)
        productRecyclerview.adapter =recyclerAdapter

    }

    private fun initViewModel() {
        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                recyclerAdapter.setCountryList(it)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }


}
