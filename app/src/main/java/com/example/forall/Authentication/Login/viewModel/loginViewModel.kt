package com.example.forall.Authentication.Login.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forall.Authentication.Login.Repo.loginRepo
import kotlinx.coroutines.launch
import kotlin.math.log

class loginViewModel(val loginRepo: loginRepo):ViewModel() {
    private val _emailExists = MutableLiveData<Boolean>()
    val emailExists : LiveData<Boolean> = _emailExists
    private val _emailMatchesPassword =MutableLiveData<Boolean>()
    val emailMatchesPassword : LiveData<Boolean> = _emailMatchesPassword
    fun ifUserWithEmailExists(email: String) {
        viewModelScope.launch {
            val response= loginRepo.ifUserWithEmailExists(email)
            _emailExists.value= response
        }
    }
    fun ifEmailMatchesPassword(email: String, password: String){
        viewModelScope.launch{
            val response = loginRepo.ifEmailMatchesPassword(email, password)
            _emailMatchesPassword.value=response
        }
    }
}