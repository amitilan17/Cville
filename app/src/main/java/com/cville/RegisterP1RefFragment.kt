package com.cville

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class RegisterP1RefFragment : Fragment() {
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_p1_refugee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner: Spinner = view.findViewById(R.id.fam_spinner)
        val adapter: ArrayAdapter<Int> =
            ArrayAdapter<Int>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                (0..10).toList()
            )
        spinner.adapter = adapter

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        val name = view.findViewById<TextView>(R.id.enterNameForm_p1_ref)
        val gender = view.findViewById<RadioGroup>(R.id.radioGroup_gender_p1_ref)
        val location = view.findViewById<TextView>(R.id.locationForm_p1_ref)
        val relatives = view.findViewById<RadioGroup>(R.id.radioGroup_relatives_p1_ref)

        val nextButton = view.findViewById<FloatingActionButton>(R.id.next_fab)
        nextButton.setOnClickListener {
            val genderString =
                view.findViewById<RadioButton>(gender.checkedRadioButtonId).text.toString()
            val relativesString =
                view.findViewById<RadioButton>(relatives.checkedRadioButtonId).text.toString()
            val relativesBool = resources.getString(R.string.yes) == relativesString

            viewModel.setP1Ref(
                name = name.text.toString(),
                gender = genderString,
                location = location.text.toString(),
                withFamily = relativesBool,
                personsNumber = spinner.selectedItem.toString().toInt()
            )
            findNavController().navigate(R.id.action_registerP1RefugeeFragment_to_registerP2RefugeeFragment)
        }
    }
}