package com.cville

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


class RegisterP2RefFragment : Fragment() {

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_p2_refugee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        val nextButton = view.findViewById<Button>(R.id.next_fab_p2_ref)
        nextButton.setOnClickListener {

            var helps: String = ""
            helps += view.findViewById<CheckBox>(R.id.check1).text
            helps += view.findViewById<CheckBox>(R.id.check2).text
            helps += view.findViewById<CheckBox>(R.id.check3).text
            helps += view.findViewById<CheckBox>(R.id.check4).text
            helps += view.findViewById<CheckBox>(R.id.check5).text
            helps += view.findViewById<CheckBox>(R.id.check6).text
            helps += view.findViewById<CheckBox>(R.id.check7).text
            helps += view.findViewById<EditText>(R.id.others).text

            viewModel.user.helps = helps

            findNavController().navigate(R.id.action_registerP2RefFragment_to_registerP3RefFragment)
        }
    }
}