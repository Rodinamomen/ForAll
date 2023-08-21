package com.example.forall.Authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.forall.R
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment() {
    lateinit var loginTxt: ImageView
    lateinit var userName: TextInputLayout
    lateinit var email:TextInputLayout
    lateinit var password:TextInputLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginTxt = requireActivity().findViewById(R.id.signup_arrow)
        userName=requireActivity().findViewById(R.id.username_TextInput)
        email=requireActivity().findViewById(R.id.email_textInput_login)
        password=requireActivity().findViewById(R.id.password_textinput_login)
        loginTxt.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
    }
   /* fun validateUserData(userName: String,password: String,email: String):Boolean{
     /*   if(validateEmail(email)&&validatePassword(password)&&validateUserName(userName)){

        }*/

    }*/
    fun validateUserName(userName:String):Boolean{
        val userNameRegex = "^[A-Za-z][A-Za-z0-9_]{7,29}".toRegex()
        return userName.matches( userNameRegex)
    }
    fun validatePassword(password : String):Boolean{
        val passwordRegex = "^[A-Za-z]{3,30}\$".toRegex()
        return password.matches(passwordRegex)
    }
    fun validateEmail(email:String):Boolean{
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()
        return email.matches(emailRegex)
    }
    fun gettingViewModelReady(){

    }
}