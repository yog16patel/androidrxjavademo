package yg.android.api

import io.reactivex.Observable
import retrofit2.http.GET
import yg.android.model.QOD

interface ApiInterface {
    @GET("qod")
    fun getQOD(): Observable<QOD>
}