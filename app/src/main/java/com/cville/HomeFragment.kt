package com.cville

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
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

        val profileButton = view.findViewById<Button>(R.id.DummyProfile)
        profileButton.setOnClickListener {
            val user = User("1111", "Amit", R.drawable.plus, "My name is Amit and I need help",null)
            val directions= HomeFragmentDirections.actionHomeFragmentToProfileFragment(user)
            findNavController().navigate(directions)
        }

        val infoButton = view.findViewById<Button>(R.id.Info)
        infoButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_infoFragment)
        }

        val helpButton = view.findViewById<Button>(R.id.Help)
        helpButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_helpFragment)
        }

        val newConnectionButton = view.findViewById<Button>(R.id.NewConnection)
        newConnectionButton.setOnClickListener {
            // activate searching algorithm to get connection
            // navigate to profile frag for given connection
        }

        val editProfileButton = view.findViewById<Button>(R.id.EditProfile)
        newConnectionButton.setOnClickListener {
            // navigate to my profile
        }
    }
}