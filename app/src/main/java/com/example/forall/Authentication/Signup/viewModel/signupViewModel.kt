package com.example.forall.Authentication.Signup.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forall.Authentication.Signup.Repo.signupRepo
import com.example.forall.Database.User
import kotlinx.coroutines.launch

class signupViewModel(val signupRepo: signupRepo):ViewModel() {
    private val _userById = MutableLiveData<User>()
    val userById :LiveData<User> = _userById
    private val _ifUserWithEmailExists = MutableLiveData<Boolean>()
    val ifUserWithEmailExists :LiveData<Boolean> = _ifUserWithEmailExists
    fun addUser(user: User) {
          viewModelScope.launch {
              signupRepo.addUser(user)
          }
    }
      fun deleteUser(user: User) {
          viewModelScope.launch {
              signupRepo.deleteUser(user)
          }

    }

     fun getUserById(userId: Int) {
         viewModelScope.launch {
             val response= signupRepo.getUserById(userId)
             _userById.value=response
         }
    }
    fun  ifUserWithEmailExists(email:String){
        viewModelScope.launch {
            val response = signupRepo.ifUserWithEmailExists(email)
            _ifUserWithEmailExists.value=response
        }
    }
}