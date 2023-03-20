package com.example.pain_and_gain_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.pain_and_gain_app.databinding.FragmentChadAddBinding

class ChadAddFragment : Fragment() {

    private lateinit var binding: FragmentChadAddBinding
    private val fragmentViewModel: FragmentViewModel by activityViewModels()
    private var role: NetWorth = NetWorth.BROKIE
    private var playerStatus: String = "0 (incel)"
    private val netWorths = NetWorth.values()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChadAddBinding.inflate(layoutInflater)

        val spinner = binding.spinner
        val adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, netWorths.map { item -> item.value })
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                println(selectedItem)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onStart() {
        super.onStart()

        binding.radioGfGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedButton = group.findViewById<RadioButton>(checkedId)
            playerStatus = selectedButton.text.toString()
        }

        binding.addButton.setOnClickListener {
            var hasErrors = false

            binding.addLayout.children.filterIsInstance<CustomEditText>().forEach {
                if (!it.validateInput()) {
                    hasErrors = true
                }
            }

            if (!(hasErrors)) {
                val chadissimus = TopG(
                    binding.textViewFirstname.text.toString(),
                    binding.textViewLastname.text.toString(),
                    Integer.parseInt(binding.textViewAge.text.toString()),
                    binding.textViewNationality.text.toString(),
                    binding.textViewPlaceofbirth.text.toString(),
                    binding.textViewPlaceofresidence.text.toString(),
                    Integer.parseInt(binding.textViewHeight.text.toString()),
                    Integer.parseInt(binding.textViewWeight.text.toString()),
                    role,
                    Integer.parseInt(binding.textViewBenchWeight.text.toString()),
                    Integer.parseInt(binding.textViewSquatWeight.text.toString()),
                    playerStatus,
                    binding.textViewBugatti.text.toString()
                )

                fragmentViewModel.addTopG(chadissimus)

                binding.addLayout.children.filterIsInstance<CustomEditText>().forEach { it.text?.clear() }

                val parentActivity = activity as MainActivity
                parentActivity.changeBottomNavigationSelectedItem(1)

                val listFragment = ListFragment()
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, listFragment)
                transaction.addToBackStack(null)

                transaction.commit()
            }
        }
    }
}
