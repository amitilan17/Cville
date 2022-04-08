package com.cville

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MatchFragment() : Fragment() {

    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextButton = view.findViewById<ImageButton>(R.id.next_match)
        nextButton.setOnClickListener {
//            findNavController().navigate(R.id.action_matchFragment_to_lookingForConnectionFragment)
        }

        val chatButton = view.findViewById<ImageButton>(R.id.chat_match)
        chatButton.setOnClickListener {
//            findNavController().navigate(R.id.action_profileFragment_to_chatFragment)
        }

//        val userDescription = view.findViewById<TextView>(R.id.description_match)
//        userDescription.text = user.description
    }
}