package com.cville

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [LookingForConnectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LookingForConnectionFragment : Fragment() {

    val r = Runnable { afterAnimation() }
    val handler: Handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_looking_for_connection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val videoView = view.findViewById<VideoView>(R.id.videoView)
//        videoView!!.setVideoPath("android.resource://" + requireContext().packageName + "/" + R.raw.sample)
//
//        videoView.start() //start() method of the VideoView class will start the video to play

        handler.postDelayed(r,1000)
    }

    private fun afterAnimation(){
        findNavController().navigate(R.id.action_lookingForConnectionFragment_to_matchFragment)
    }
}