package pl.szarek.lab5_8.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.szarek.lab5_8.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListFragment()
    }

    fun showListFragment() {
        val listFragment = ListFragment.getInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, listFragment)
            .commit()
    }

    fun showAddFragment() {
        val addFragment = AddFragment.getInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, addFragment)
            .commit()
    }
}
