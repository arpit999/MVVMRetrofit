package ca.temi.mvvmretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.temi.mvvmretrofit.cloud.API
import ca.temi.mvvmretrofit.cloud.RetrofitHelper
import ca.temi.mvvmretrofit.repository.CoinRepository
import ca.temi.mvvmretrofit.viewmodel.MainViewModel
import ca.temi.mvvmretrofit.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private val Any.TAG: String get() = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coinServices = RetrofitHelper.getInstance().create(API::class.java)
        val coinRepository = CoinRepository(coinServices)

//       mainViewModel =  ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(coinRepository)).get(MainViewModel::class.java)

        mainViewModel.coins.observe(this, Observer {
            Log.d(TAG, "Response : $it")
        })

    }
}