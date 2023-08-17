package com.example.forall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.forall.Repo.productsRepo
import com.example.forall.network.Product
import com.example.forall.network.products
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class productsViewModel(val productsRepo: productsRepo) :ViewModel(){
    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>> = _productList
    fun getProductsList(){
        viewModelScope.launch(){
            val response= productsRepo.getProductsFromApi()
            _productList.value=response.products
        }
    }
}