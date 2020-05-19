package pl.szarek.lab5_8.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import pl.szarek.lab5_8.R
import pl.szarek.lab5_8.database.entity.Language

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private lateinit var nameTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findViews()
    }

    private fun findViews() {
        nameTextView = requireView().findViewById(R.id.nameTextView)
    }

    fun showDetails(language: Language) {
        nameTextView.text = language.name
    }

    companion object {
        fun getInstance(): DetailsFragment =
            DetailsFragment()
    }
}