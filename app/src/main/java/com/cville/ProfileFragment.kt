package com.cville

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProfileFragment() : Fragment() {

    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        val args = ProfileFragmentArgs.fromBundle(bundle!!)
        user = args.user

        val chatButton = view.findViewById<Button>(R.id.chat)
        chatButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_chatFragment)
        }

//        val userImage = view.findViewById<ImageView>(R.id.image)
//        userImage.setImageDrawable(requireContext().getDrawable(user.imageRes))

        val userDescription = view.findViewById<TextView>(R.id.description)
        userDescription.text = user.description

    }
}