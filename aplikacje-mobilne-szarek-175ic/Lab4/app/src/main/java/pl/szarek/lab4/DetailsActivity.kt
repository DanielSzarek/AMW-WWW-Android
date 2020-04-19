package pl.szarek.lab4
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class DetailsActivity : AppCompatActivity() {
    private lateinit var detailsTextView: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        findViews()
        initializeViews()
        setSupportActionBar(toolbar)
    }

    private fun findViews() {
        toolbar = findViewById(R.id.toolbar)
        detailsTextView = findViewById(R.id.details_text_view)
    }

    private fun initializeViews() {
        val item = intent.getStringExtra("item_key")
        detailsTextView.text = item
    }
}
