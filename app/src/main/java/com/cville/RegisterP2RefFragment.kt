package com.cville

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


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
        viewModel = ViewModelProvider(requireActivity()).get(RegisterViewModel::class.java)

        val nextButton = view.findViewById<FloatingActionButton>(R.id.next_fab_p2_ref)
        nextButton.setOnClickListener {

            var helps: String = ""
//            helps += view.findViewById<ImageButton>(R.id.clothes_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.transport_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.food_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.bearucracy_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.translation_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.accomodation_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.education_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.work_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.health_button).toString()
//            helps += view.findViewById<ImageButton>(R.id.other_button).toString()

            viewModel.user.helps = helps

            findNavController().navigate(R.id.action_registerP2RefFragment_to_registerP3RefFragment2)
        }
    }
}