package com.example.forall.Home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forall.Authentication.Login.Repo.loginRepo
import com.example.forall.Authentication.Login.viewModel.loginViewModel
import com.example.forall.Home.repo.homeRepo
import java.lang.IllegalArgumentException

class homeViewModelFactory(val homeRepo: homeRepo):ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(homeViewModel::class.java)) {
               homeViewModel(homeRepo) as T
            }else{
                throw IllegalArgumentException("home view model class not found")
            }
        }
}