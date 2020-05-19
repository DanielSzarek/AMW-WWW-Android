package pl.szarek.lab5_8.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.szarek.lab5_8.R
import pl.szarek.lab5_8.database.entity.Language

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var detailsFragment: DetailsFragment
    private lateinit var listFragment: ListFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDetailsFragment()
        showListFragment()
    }

    fun showDetailsFragment() {
        detailsFragment = DetailsFragment.getInstance()
        childFragmentManager.beginTransaction()
            .add(R.id.detailsContainer, detailsFragment)
            .commit()
    }

    fun showListFragment() {
        val listener = object : LanguageClickListener {
            override fun onLanguageClick(language: Language) {
                detailsFragment.showDetails(language)
            }
        }

        listFragment = ListFragment.getInstance(listener)
        childFragmentManager.beginTransaction()
            .add(R.id.listContainer, listFragment)
            .commit()
    }

    companion object {
        fun getInstance(): MainFragment =
            MainFragment()
    }

    interface LanguageClickListener {
        fun onLanguageClick(language: Language)
    }
}