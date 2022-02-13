package hr.ferit.nikolinastjepanovic.bookbf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SecondActivity : AppCompatActivity() {
    var category: String = ""
    var order: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.buttonBack).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttonFind).setOnClickListener {
            val selectedOption: Int = findViewById<RadioGroup>(R.id.radioGroup)!!.checkedRadioButtonId
            when (selectedOption) {
                R.id.romance -> {
                    category = "romance"
                }
                R.id.history -> {
                    category = "history"
                }
                R.id.poetry -> {
                    category = "poetry"
                }
                R.id.fiction -> {
                    category = "fiction"
                }
                R.id.thriller -> {
                    category = "thriller"
                }
                R.id.drama -> {
                    category = "drama"
                }
                R.id.fantasy -> {
                    category = "fantasy"
                }
                R.id.crime -> {
                    category = "crime"
                }
            }

            val selectedOrder: Int = findViewById<RadioGroup>(R.id.RadioGroup2)!!.checkedRadioButtonId
            when (selectedOrder) {
                R.id.relevance -> {
                    order = "relevance"
                }
                R.id.newest -> {
                    order = "newest"
                }
            }


            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("category", category)
            intent.putExtra("orderBy", order)
            startActivity(intent)
        }
    }
}