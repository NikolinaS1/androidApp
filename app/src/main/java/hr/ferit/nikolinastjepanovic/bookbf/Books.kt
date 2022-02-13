package hr.ferit.nikolinastjepanovic.bookbf

import java.util.*
import kotlin.collections.ArrayList

data class ResponseData(
    val totalItems: Number,
    val items: ArrayList<Books>
)

data class Books (
    val id: String,
    val volumeInfo: BookInfo
)

data class BookInfo (
    val title: String,
    val description: String,
    val publisher: String,
    val publishedDate: String,
    val authors: ArrayList<String>,
    val averageRating: Number,
    val imageLinks: ImageInfo
        )

data class ImageInfo (
    val thumbnail: String
        )