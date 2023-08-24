package com.example.forall.Authentication.Signup.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import com.example.forall.Authentication.Signup.Repo.signupRepoImp
import com.example.forall.Authentication.Signup.viewModel.signupViewModel
import com.example.forall.Authentication.Signup.viewModel.signupViewModelFactory
import com.example.forall.Database.User
import com.example.forall.Database.localDataSource.localDatabaseImp
import com.example.forall.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment() {
    lateinit var login_arrow: ImageView
    lateinit var userName: TextInputLayout
    lateinit var email:TextInputLayout
    lateinit var password:TextInputLayout
    lateinit var SignupViewModel: signupViewModel
    lateinit var signup_btn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_arrow = view.findViewById(R.id.login_arrow)
        userName=view.findViewById(R.id.signupusername_TextInput)
        email=view.findViewById(R.id.loginemail_textInput_login)
        password=view.findViewById(R.id.loginpassword_textinput)
        signup_btn=view.findViewById(R.id.login)
        gettingViewModelReady(requireContext())
        login_arrow.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
        SignupViewModel.ifUserWithEmailExists.observe(requireActivity()){ data->
            Log.d("dataaaaa", "onViewCreated: ${false}")
            if(data != null){
            if(data){
                MaterialAlertDialogBuilder(requireContext()).setTitle("The Account Is Signed In").setMessage("That email address is associated with a user account.").setPositiveButton("Ok", null)
                    .show()
            }else {
                validateUserData(
                    userName.editText?.text.toString(),password.editText?.text.toString(),email.editText?.text.toString())
            }
        }}
        signup_btn.setOnClickListener {
            SignupViewModel.ifUserWithEmailExists(email.editText?.text.toString())
        }
    }
    fun validateUserData(userName: String,password: String,email: String){
        if(validateEmail(email)&&validatePassword(password)&&validateUserName(userName)){
            Log.d("TAG", "validateUserData: ${validateEmail(email)&&validatePassword(password)&&validateUserName(userName)}")
            SignupViewModel.addUser(User(userName =userName, email = email, password = password))
            Toast.makeText(context, "done", Toast.LENGTH_SHORT).show()
             }
        if(!validateEmail(email)){
            MaterialAlertDialogBuilder(requireContext()).setTitle("Invalid Email").setMessage("Check that the email you entered is a valid email").setPositiveButton("Ok", null)
                .show()
        }
        if(!validatePassword(password)){
            MaterialAlertDialogBuilder(requireContext()).setTitle("Invalid Password").setMessage("A password must have between four and eight letters, both lowercase and uppercase letters, and contain special characters.").setPositiveButton("Ok", null)
                .show()
        }
        if(!validateUserName(userName)){
            MaterialAlertDialogBuilder(requireContext()).setTitle("Invalid User Name").setMessage("In the User Name, there must be 3 to 30 letters, either capital or small").setPositiveButton("Ok", null)
                .show()
        }
    }
    fun validateUserName(userName:String):Boolean{

        val userNameRegex ="^[A-Za-z]{3,30}\$".toRegex()
        return userName.matches( userNameRegex)
    }
    fun validatePassword(password : String):Boolean{

        val passwordRegex =   "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,8}$".toRegex()
        return password.matches(passwordRegex)
    }
    fun validateEmail(email:String):Boolean{
        val emailRegex =  "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()
        return email.matches(emailRegex)
    }
   fun gettingViewModelReady(context: Context){
      val signupViewModelFactory= signupViewModelFactory(signupRepoImp(localDatabaseImp(context)))
       SignupViewModel= ViewModelProvider(this,signupViewModelFactory).get(signupViewModel::class.java)
   }
}