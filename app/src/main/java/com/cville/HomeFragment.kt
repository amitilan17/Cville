package com.cville

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = ViewModelProvider(this).get(MainViewModel::class.java)
        val userName = view.findViewById<TextView>(R.id.name)
        userName.text = "Hello ${vm.user.name} ,"

        val messageButton = view.findViewById<ImageButton>(R.id.message_button)
        messageButton.setOnClickListener {
            val directions = HomeFragmentDirections.actionHomeFragmentToMatchFragment(vm.user)
            findNavController().navigate(directions)
        }

        val infoButton = view.findViewById<ImageButton>(R.id.rights_info_button)
        infoButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_infoFragment)
        }

        val helpButton = view.findViewById<ImageButton>(R.id.relevant_non_profit_button)
        helpButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_helpFragment)
        }
        val newConnectionButton = view.findViewById<ImageButton>(R.id.new_connection_button)
        newConnectionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_lookingForConnectionFragment)
        }

        // todo: make sure edit fragments show previous fields
        val editProfileButton = view.findViewById<ImageButton>(R.id.edit_profile_button)
        editProfileButton.setOnClickListener {
//            ViewModelProvider(requireActivity()).get(MainViewModel::class.java).loadMainUser {
//                ViewModelProvider(requireActivity()).get(RegisterViewModel::class.java).user = it
//            }
            findNavController().navigate(R.id.action_homeFragment_to_registerP1RefFragment)
        }
    }
}