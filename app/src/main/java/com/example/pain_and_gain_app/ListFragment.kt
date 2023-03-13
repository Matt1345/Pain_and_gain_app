package com.example.pain_and_gain_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.pain_and_gain_app.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var binding: FragmentListBinding
    private val fragmentViewModel: FragmentViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)

        fragmentViewModel.data.observe(viewLifecycleOwner) { chadList ->
            val adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, chadList)
            val listView = binding.myListview
            listView.adapter = adapter
            val spremnik = binding.conLayout

            spremnik.removeAllViews()

            chadList.forEach { chad ->
                val textView = TextView(requireContext())
                textView.text = chad.toString()
                listView.addHeaderView(textView)
            }
            spremnik.addView(listView)
        }
        return binding.root
    }
}