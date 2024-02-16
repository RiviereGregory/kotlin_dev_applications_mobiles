package mrs.riverjach.allerplusloinaveckotlin.services

import retrofit2.Call
import retrofit2.http.GET

interface HttpServiceString {

    @GET("user-agent")
    fun getUserAgent(): Call<String>
}