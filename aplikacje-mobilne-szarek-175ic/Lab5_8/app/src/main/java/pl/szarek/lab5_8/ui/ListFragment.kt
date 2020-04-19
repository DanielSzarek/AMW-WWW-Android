package pl.szarek.lab5_8.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.szarek.lab5_8.R
import pl.szarek.lab5_8.RecyclerViewAdapter
import pl.szarek.lab5_8.database.ApplicationDatabase
import pl.szarek.lab5_8.database.dao.LanguageDao
import pl.szarek.lab5_8.database.entity.Language

class ListFragment : Fragment() {
    private lateinit var database: ApplicationDatabase
    private lateinit var languageDao: LanguageDao

    private lateinit var addButton: FloatingActionButton
    private lateinit var languagesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = ApplicationDatabase.invoke(requireActivity().application)
        languageDao = database.getLanguageDao()

        findViews()
        setListeners()
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
        val adapter = RecyclerViewAdapter(languages)
        languagesRecyclerView.adapter = adapter
    }

    private fun findViews() {
        addButton = requireView().findViewById(R.id.add_button)
        languagesRecyclerView = requireView().findViewById(R.id.languages_recycler_view)
    }

    private fun setListeners() {
        addButton.setOnClickListener {
            goToAddFragment()
        }
    }

    private fun goToAddFragment() {
        (activity as? MainActivity)?.showAddFragment()
    }

    companion object {
        fun getInstance(): ListFragment =
            ListFragment()
    }
}