package mrs.riverjach.allerplusloinaveckotlin.services

import mrs.riverjach.allerplusloinaveckotlin.parser.GetData
import retrofit2.Call
import retrofit2.http.GET

interface HttpServiceJson {
    @GET("get")
    fun getUserInfo(): Call<GetData>
}