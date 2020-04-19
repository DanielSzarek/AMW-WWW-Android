package pl.szarek.lab4
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class CategoriesActivity : AppCompatActivity() {
    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        findViews()
        initializeRecyclerView()
        setSupportActionBar(toolbar)
    }

    private fun findViews() {
        toolbar = findViewById(R.id.toolbar)
        categoriesRecyclerView = findViewById(R.id.categories_recycler_view)
    }

    private fun initializeRecyclerView() {
        val categories = resources.getStringArray(R.array.categories_array)
        val listener = object : RecyclerViewAdapter.ItemClickListener {
            override fun onClick(item: String) {
                goToDetailsActivity(item)
            }
        }

        categoriesRecyclerView.adapter = RecyclerViewAdapter(categories.toList(), listener)
    }

    private fun goToDetailsActivity(item: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("item_key", item)
        startActivity(intent)
    }
}
