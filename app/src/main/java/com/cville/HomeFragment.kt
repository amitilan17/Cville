package com.cville

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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



        val profileButton = view.findViewById<Button>(R.id.ProfileBox)
        profileButton.setOnClickListener {
//            val user = User("1111", "Amit", Firebase.auth.currentUser?.photoUrl, "My name is Amit and I need help",null)
//            ViewModelProvider(this).get(MainViewModel::class.java).getUserObj("1111") {
//                val directions = HomeFragmentDirections.actionHomeFragmentToProfileFragment(it)
//                findNavController().navigate(directions)
//            }
            findNavController().navigate(R.id.action_homeFragment_to_lookingForConnectionFragment)
        }

        ViewModelProvider(this).get(MainViewModel::class.java).getUserObj("1111"){
            val imageView = view.findViewById<ImageView>(R.id.profile_image)
            MainViewModel.setProfileImgToView(requireContext(), it.image, imageView)

            val userName = view.findViewById<TextView>(R.id.name)
            userName.text = it.name
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

        // todo: make sure edit fragments show previous fields
        val editProfileButton = view.findViewById<Button>(R.id.EditProfile)
        editProfileButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_registerP1RefugeeFragment)
        }
    }
}