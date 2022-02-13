package hr.ferit.nikolinastjepanovic.bookbf

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val category = intent.getStringExtra("category")
        val orderBy = intent.getStringExtra("orderBy")

        val request =
            ServiceBuilder.buildService(FakerEndpoints::class.java)
        val call = request.getBooks("subject:" + category!!,  orderBy!!)

        call.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>)
            {
                if(response.isSuccessful) {
                    findViewById<RecyclerView>(R.id.bookList).apply {
                        layoutManager =
                            LinearLayoutManager(this@ThirdActivity)
                        adapter =
                            BooksRecyclerAdapter(response.body()!!.items)
                    }
                }
            }
            override fun onFailure(call: Call<ResponseData>, t: Throwable)
            {
                Log.d("FAIL", t.message.toString())
            }
        })
        findViewById<Button>(R.id.tryAgain).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}