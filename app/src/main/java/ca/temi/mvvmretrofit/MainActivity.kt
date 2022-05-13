package ca.temi.mvvmretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.temi.mvvmretrofit.cloud.API
import ca.temi.mvvmretrofit.cloud.RetrofitHelper
import ca.temi.mvvmretrofit.databinding.ActivityMainBinding
import ca.temi.mvvmretrofit.repository.CoinRepository
import ca.temi.mvvmretrofit.viewmodel.MainViewModel
import ca.temi.mvvmretrofit.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private val Any.TAG: String get() = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val coinServices = RetrofitHelper.getInstance().create(API::class.java)
        val coinRepository = CoinRepository(coinServices)

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(coinRepository)
        ).get(MainViewModel::class.java)

        mainViewModel.coins.observe(this, Observer {
            Log.d(TAG, "Response : $it")
        })

    }
}