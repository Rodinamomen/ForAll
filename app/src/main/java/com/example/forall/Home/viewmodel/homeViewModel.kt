package com.example.forall.Home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forall.Database.Product
import com.example.forall.Home.repo.homeRepo
import kotlinx.coroutines.launch

class homeViewModel(val homeRepo: homeRepo): ViewModel() {
    private val _productList = MutableLiveData<List<Product>>()
    val productList : LiveData<List<Product>> = _productList

    fun getproductslist() {
        viewModelScope.launch {
            val response = homeRepo.getproductslist()
            _productList.value= response
        }
    }

}