package com.example.forall.Authentication.Login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forall.Authentication.Login.Repo.loginRepo
import com.example.forall.Authentication.Signup.viewModel.signupViewModel
import java.lang.IllegalArgumentException

class loginViewModelFactory(val loginRepo: loginRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(loginViewModel::class.java)) {
           loginViewModel(loginRepo) as T
        }else{
            throw IllegalArgumentException("signup view model class not found")
        }
    }
}