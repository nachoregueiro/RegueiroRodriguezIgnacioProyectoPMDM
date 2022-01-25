package Dao.retrofit

import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private fun clienteRetroFit(): Retrofit {
        val retrofit =Retrofit.builder
            .baseUrl("https://damapi.herokuapp.com/api/v1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit

    }



    val apiRetroFit= clienteRetroFit().create(Api::class.java)