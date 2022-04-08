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

//        ViewModelProvider(this).get(MainViewModel::class.java).loadMainUser {
//            val imageView = view.findViewById<ImageView>(R.id.profile_image)
//            MainViewModel.setProfileImgToView(requireContext(), it.image, imageView)
//
//            val userName = view.findViewById<TextView>(R.id.name)
//            userName.text = it.name
//        }
//        val profileButton = view.findViewById<ImageButton>(R.id.ProfileBox)
//        profileButton.setOnClickListener {
//            val user = User("1111", "Amit", Firebase.auth.currentUser?.photoUrl, "My name is Amit and I need help",null)
//            ViewModelProvider(this).get(MainViewModel::class.java).getUserObj("1111") {
//                val directions = HomeFragmentDirections.actionHomeFragmentToProfileFragment(it)
//                findNavController().navigate(directions)
//            }
//            findNavController().navigate(R.id.action_homeFragment_to_lookingForConnectionFragment)
//        }

        ViewModelProvider(this).get(MainViewModel::class.java).getUserObj("Zq8Eur5engREwAogfhLP5S82OTX2\n", {
            val imageView = view.findViewById<ImageView>(R.id.profile_image)
            MainViewModel.setProfileImgToView(requireContext(), it.image, imageView)

            val userName = view.findViewById<TextView>(R.id.name)
            userName.text = it.name
        }, {})

        val infoButton = view.findViewById<ImageButton>(R.id.rights_info_button)
        infoButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_infoFragment)
        }

        val helpButton = view.findViewById<ImageButton>(R.id.relevant_non_profit_button)
        helpButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_helpFragment)
        }

        val newConnectionButton = view.findViewById<ImageButton>(R.id.new_connection_button_text)
        newConnectionButton.setOnClickListener {
            // activate searching algorithm to get connection
            // navigate to profile frag for given connection
        }

        // todo: make sure edit fragments show previous fields
        val editProfileButton = view.findViewById<ImageButton>(R.id.edit_profile_button)
        editProfileButton.setOnClickListener {
            ViewModelProvider(requireActivity()).get(MainViewModel::class.java).loadMainUser {
                ViewModelProvider(requireActivity()).get(RegisterViewModel::class.java).user = it
            }
            findNavController().navigate(R.id.action_homeFragment_to_registerP1RefugeeFragment)
        }
    }
}