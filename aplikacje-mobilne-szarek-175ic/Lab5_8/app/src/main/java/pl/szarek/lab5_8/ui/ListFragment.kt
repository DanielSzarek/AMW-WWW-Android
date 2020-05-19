package pl.szarek.lab5_8.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.szarek.lab5_8.R
import pl.szarek.lab5_8.RecyclerViewAdapter
import pl.szarek.lab5_8.database.ApplicationDatabase
import pl.szarek.lab5_8.database.dao.LanguageDao
import pl.szarek.lab5_8.database.entity.Language

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var database: ApplicationDatabase
    private lateinit var languageDao: LanguageDao

    private lateinit var languagesRecyclerView: RecyclerView

    var listener: MainFragment.LanguageClickListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = ApplicationDatabase.invoke(requireActivity().application)
        languageDao = database.getLanguageDao()

        findViews()
        addLanguages()
    }

    private fun addLanguages() {
        val languages = listOf(
            Language("Python"),
            Language("Java"),
            Language("Kotlin"),
            Language("PHP")
        )

        lifecycleScope.launch(Dispatchers.IO) {
            languageDao.insertAll(languages)
            val languages = languageDao.getAll()

            withContext(Dispatchers.Main) {
                showLanguages(languages)
            }
        }
    }

    private fun showLanguages(languages: List<Language>) {
        val adapter = RecyclerViewAdapter(languages, listener)
        languagesRecyclerView.adapter = adapter
    }

    private fun findViews() {
        languagesRecyclerView = requireView().findViewById(R.id.languages_recycler_view)
    }

    companion object {
        fun getInstance(listener: MainFragment.LanguageClickListener): ListFragment {
            val fragment = ListFragment()
            fragment.listener = listener

            return fragment
        }
    }
}