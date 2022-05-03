package ca.temi.mvvmretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ca.temi.mvvmretrofit.cloud.API
import ca.temi.mvvmretrofit.model.coin_detail.CoinDetails
import ca.temi.mvvmretrofit.model.CoinList

class CoinRepository(private val apiService: API) {

    private var coinListLiveData: MutableLiveData<CoinList> = MutableLiveData()

    val coinList: LiveData<CoinList>
        get() = coinListLiveData

    private var coinDetailLiveData: MutableLiveData<CoinDetails> = MutableLiveData()

    val coinDetail: LiveData<CoinDetails>
        get() = coinDetailLiveData


    suspend fun getAllCoins() {
        var result = apiService.getAllCoins()

        if (result.body() != null) {
            coinListLiveData.postValue(result.body())
        }
    }


    suspend fun getCoinDetails(id: String) {
        var result = apiService.getCoinDetails(id)

        if (result.body() != null) {
            coinDetailLiveData.postValue(result.body())
        }
    }

}