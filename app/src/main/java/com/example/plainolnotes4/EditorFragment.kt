package com.example.plainolnotes4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.plainolnotes4.databinding.EditorFragmentBinding

class EditorFragment : Fragment() {

    private lateinit var viewModel: EditorViewModel
    private val args: EditorFragmentArgs by navArgs()
    private lateinit var binding: EditorFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as AppCompatActivity).supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_check)
        }
        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)

        binding = EditorFragmentBinding.inflate(inflater, container, false)
        binding.editor.setText("")

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    saveAndReturn()
                }
            }
        )

        viewModel.currentNote.observe(viewLifecycleOwner, {
            binding.editor.setText(it.text)
        })
        viewModel.getNoteById(args.noteId)

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> saveAndReturn()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveAndReturn(): Boolean {
        findNavController().navigateUp()
        return true
    }
}
