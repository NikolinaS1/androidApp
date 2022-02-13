package hr.ferit.nikolinastjepanovic.bookbf

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FakerEndpoints {
    @GET("/books/v1/volumes")
    fun getBooks(@Query("q") category: String, @Query("orderBy") orderBy: String): Call<ResponseData>
}