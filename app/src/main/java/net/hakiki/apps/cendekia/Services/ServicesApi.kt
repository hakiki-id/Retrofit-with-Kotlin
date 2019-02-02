package net.hakiki.apps.cendekia.Services

import io.reactivex.Completable
import io.reactivex.Observable
import net.hakiki.apps.cendekia.Models.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ServicesApi {

    @GET("user/email/check/{email}")
    fun checkAvailableMail(@Path("email") email : String) : Observable<Response>


}