package ca.temi.mvvmretrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.temi.mvvmretrofit.model.CoinList
import ca.temi.mvvmretrofit.model.coin_detail.CoinDetails
import ca.temi.mvvmretrofit.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val coinRepository: CoinRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            coinRepository.getAllCoins()
        }
    }

    val coins : LiveData<CoinList>
    get() = coinRepository.coinList

}