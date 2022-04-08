package com.cville

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class RegisterP3RefFragment : Fragment() {

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_p3_refugee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        val nextButton = view.findViewById<Button>(R.id.next_fab_p3_ref)
        nextButton.setOnClickListener {

            viewModel.user.description =
                view.findViewById<EditText>(R.id.enterLocationForm_p3_ref).text.toString()
            viewModel.user.let { newUser: User ->
                ViewModelProvider(this).get(MainViewModel::class.java).let {
                    it.uploadUser(newUser)
                    it.user = newUser
                }
            }
            findNavController().navigate(R.id.action_registerP3RefFragment_to_lookingForConnectionFragment)
        }
    }
}