package ca.temi.mvvmretrofit.cloud

import ca.temi.mvvmretrofit.model.coin_detail.CoinDetails
import ca.temi.mvvmretrofit.model.CoinList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("/v1/coins")
    suspend fun getAllCoins(): Response<CoinList>

    @GET("/v1/coins/{coin}")
    suspend fun getCoinDetails(@Path("coin") coin: String): Response<CoinDetails>


}