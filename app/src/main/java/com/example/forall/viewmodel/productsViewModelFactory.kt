package com.example.forall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forall.Repo.productsRepo
import java.lang.IllegalArgumentException

class productsViewModelFactory(val productsRepo: productsRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(productsViewModel::class.java)) {
            productsViewModel(productsRepo) as T
        }else{
            throw IllegalArgumentException("productview model class not found")
        }
    }
}