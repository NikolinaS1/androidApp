package hr.ferit.nikolinastjepanovic.bookbf


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BooksRecyclerAdapter(private val items: List<Books>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        return BookViewHolder(

            LayoutInflater.from(parent.context).inflate(R.layout.layout_books, parent,
                false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {
        when(holder) {
            is BookViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class BookViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val photoImage: ImageView =
            itemView.findViewById(R.id.bookImage)
        private val bookTitle: TextView =
            itemView.findViewById(R.id.bookTitle)
        private val bookDescription: TextView =
            itemView.findViewById(R.id.bookDescription)
        fun bind(books: Books) {
            val url = if (books.volumeInfo.imageLinks != null)
                books.volumeInfo.imageLinks.thumbnail
                else "https://books.google.com/books/content?id=dB4DkjvulXQC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            val uri = url.toUri().buildUpon().scheme("https").build()

            Glide
                .with(itemView.context)
                .load(uri)
                .into(photoImage)

            bookTitle.text = books.volumeInfo.title
            if (books.volumeInfo.description != null) {
                bookDescription.text = books.volumeInfo.description
            }
            else {
                bookDescription.text = "No description!"
            }
        }
    }
}