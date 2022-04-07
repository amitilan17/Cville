package com.cville

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class RegisterP1RefFragment : Fragment() {
    private lateinit var viewModel : RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_p1_refugee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        val name = view.findViewById<TextView>(R.id.enterNameForm_p1_ref)
        val gender = view.findViewById<RadioGroup>(R.id.radioGroup_gender_p1_ref)
        val location = view.findViewById<TextView>(R.id.locationForm_p1_ref)
        val relatives = view.findViewById<RadioGroup>(R.id.radioGroup_relatives_p1_ref)

        val nextButton = view.findViewById<Button>(R.id.Location_p1_ref)
        nextButton.setOnClickListener {
            val genderId = gender.checkedRadioButtonId
            val genderString = view.findViewById<RadioButton>(genderId).toString()
            val relativesId = relatives.checkedRadioButtonId
            val relativesString = resources.getResourceEntryName(relativesId)
            val relativesBool = relativesString==requireContext().getString(R.string.yes)

            viewModel.setP1Ref(name = name.text.toString(), gender = genderString,
                location = location.text.toString(), withFamily = relativesBool)

            findNavController().navigate(R.id.action_registerP1RefugeeFragment_to_registerP2RefugeeFragment)
        }
    }
}