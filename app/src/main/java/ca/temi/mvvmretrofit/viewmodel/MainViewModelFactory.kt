package ca.temi.mvvmretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.temi.mvvmretrofit.repository.CoinRepository

class MainViewModelFactory(private val coinRepository: CoinRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            return MainViewModel(coinRepository) as T
        }
        throw RuntimeException("Error creating viewmodel")
    }
}