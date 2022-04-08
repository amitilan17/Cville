package com.cville

import android.annotation.SuppressLint
import android.os.Bundle
import com.cville.ProfileFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cville.R

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
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

//        val bundle = arguments
//        val args = ProfileFragmentArgs.fromBundle(bundle!!)
//        user = args.user

        val chatButton = view.findViewById<Button>(R.id.chat)
        chatButton.setOnClickListener {
//            findNavController().navigate(R.id.action_profileFragment_to_chatFragment)
        }

        val imageView = view.findViewById<ImageView>(R.id.profile_image)
        MainViewModel.setProfileImgToView(requireContext(), user.image, imageView)

        val userDescription = view.findViewById<TextView>(R.id.description)
        userDescription.text = user.description
    }
}