package com.example.forall.Authentication.Signup.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forall.Authentication.Signup.Repo.signupRepo
import com.example.forall.Repo.productsRepo
import com.example.forall.viewmodel.productsViewModel
import java.lang.IllegalArgumentException

class signupViewModelFactory(val signupRepo: signupRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(signupViewModel::class.java)) {
           signupViewModel(signupRepo) as T
        }else{
            throw IllegalArgumentException("signup view model class not found")
        }
    }
}