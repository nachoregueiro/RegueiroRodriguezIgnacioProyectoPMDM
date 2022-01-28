package Dao.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClienteRetrofit {
    private fun clienteRetroFit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://damapi.herokuapp.com/api/v1/")
            .build()

        return retrofit
    }

    val apiRetroFit: Api = clienteRetroFit().create(Api::class.java)

}
