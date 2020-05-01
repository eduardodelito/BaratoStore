package com.enaz.baratostore.client

import com.enaz.baratostore.client.model.ProductResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by eduardo.delito on 4/29/20.
 */
interface BaratoApiService {
    @GET("products/")
    fun getProducts(): Single<ProductResponse>
}
