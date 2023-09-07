package com.example.forall.Home.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forall.Authentication.Login.Repo.loginRepoImp
import com.example.forall.Authentication.Login.viewModel.loginViewModel
import com.example.forall.Authentication.Login.viewModel.loginViewModelFactory
import com.example.forall.Database.localDataSource.localDatabaseImp
import com.example.forall.Home.homeAdapter
import com.example.forall.Home.repo.homeRepoImp
import com.example.forall.Home.viewmodel.homeViewModel
import com.example.forall.Home.viewmodel.homeViewModelFactory
import com.example.forall.R
import com.example.forall.Repo.productRepoImp
import com.example.forall.network.Client
import com.example.forall.network.RemoteDataSource
import com.example.forall.viewmodel.productsViewModel
import com.example.forall.viewmodel.productsViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment


lateinit var recyclerView: RecyclerView
lateinit var viewmodel : homeViewModel
lateinit var bottomNavigationView: BottomNavigationView


class homeFragment : Fragment() , NavigationView.OnNavigationItemSelectedListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gettingViewModelReady(requireContext())
        bottomNavigationView= view.findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.background = null
        recyclerView = view.findViewById(R.id.items_recycler_view)
        viewmodel.getproductslist()
        viewmodel.productList.observe(requireActivity()){ it ->
            Log.d("tag", "showProducts: $it")
            recyclerView.adapter= homeAdapter(it)
            recyclerView.layoutManager= LinearLayoutManager(requireActivity(),RecyclerView.HORIZONTAL,false)
        }
    }


   private fun gettingViewModelReady(context: Context) {
        val homeViewModelFactory =
           homeViewModelFactory(homeRepoImp(Client))
        viewmodel = ViewModelProvider(this, homeViewModelFactory).get(homeViewModel::class.java)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}