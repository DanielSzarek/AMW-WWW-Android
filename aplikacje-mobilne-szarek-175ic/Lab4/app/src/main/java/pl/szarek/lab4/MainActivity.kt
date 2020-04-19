package pl.szarek.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import pl.szarek.lab4.R

class MainActivity : AppCompatActivity() {
    private lateinit var typesRecyclerView: RecyclerView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        initializeRecyclerView()
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.info_item -> {
                goToInfoActivity()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun findViews() {
        toolbar = findViewById(R.id.toolbar)
        typesRecyclerView = findViewById(R.id.types_recycler_view)
    }

    private fun initializeRecyclerView() {
        val types = resources.getStringArray(R.array.types_array)
        val listener = object : RecyclerViewAdapter.ItemClickListener {
            override fun onClick(item: String) {
                goToCategoriesActivity()
            }
        }

        typesRecyclerView.adapter = RecyclerViewAdapter(types.toList(), listener)
    }

    private fun goToCategoriesActivity() {
        val intent = Intent(this, CategoriesActivity::class.java)
        startActivity(intent)
    }

    private fun goToInfoActivity() {
        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
    }
}
