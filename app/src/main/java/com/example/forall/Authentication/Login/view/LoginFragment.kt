package com.example.forall.Authentication.Login.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.forall.Authentication.Login.Repo.loginRepoImp
import com.example.forall.Authentication.Login.viewModel.loginViewModel
import com.example.forall.Authentication.Login.viewModel.loginViewModelFactory
import com.example.forall.Database.localDataSource.localDatabaseImp
import com.example.forall.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    lateinit var LoginViewModel: loginViewModel
    lateinit var email_txt: TextInputLayout
    lateinit var password_txt: TextInputLayout
    lateinit var signup_arrow: ImageView
    lateinit var toSignup_txt: TextView
    lateinit var login_btn:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email_txt=view.findViewById(R.id.loginemail_textInput_login)
        password_txt=view.findViewById(R.id.loginpassword_textinput)
        signup_arrow=view.findViewById(R.id.login_arrow)
        toSignup_txt=view.findViewById(R.id.tosignup_textview)
        login_btn=view.findViewById(R.id.login)
        gettingViewModelReady(requireContext())
       LoginViewModel.emailMatchesPassword.observe(requireActivity()){emailMatchesPassword->
           LoginViewModel.emailExists.observe(requireActivity()) {emailExists ->
               if (emailMatchesPassword != null) {
                   if (emailMatchesPassword) {
                       MaterialAlertDialogBuilder(requireContext()).setTitle("logged in ")
                           .setPositiveButton("Ok", null)
                           .show()
                   }else {
                       if (emailExists != null) {
                           if (emailExists) {
                               MaterialAlertDialogBuilder(requireContext()).setTitle("wrong password")
                                   .setPositiveButton("Ok", null)
                                   .show()
                           } else {
                               MaterialAlertDialogBuilder(requireContext()).setTitle("please sign up ")
                                   .setPositiveButton("Ok", null)
                                   .show()
                           }
                       }
                   }
               }
           }
       }
        login_btn.setOnClickListener {
            Log.d("checkii", "onViewCreated: ${email_txt.editText?.text.toString() + password_txt.editText?.text.toString()}")
           LoginViewModel.ifEmailMatchesPassword(email_txt.editText?.text.toString(),password_txt.editText?.text.toString())
            Log.d("checkii", "onViewCreated: ${email_txt.editText?.text.toString()}")
         LoginViewModel.ifUserWithEmailExists(email_txt.editText?.text.toString())
        }
    }
    private fun gettingViewModelReady(context: Context){
       val loginViewModelFactory = loginViewModelFactory(loginRepoImp(localDatabaseImp(context)))
        LoginViewModel= ViewModelProvider(this,loginViewModelFactory).get(loginViewModel::class.java)
    }
}