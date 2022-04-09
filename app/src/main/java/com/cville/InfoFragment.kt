package com.cville

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val olimButton = view.findViewById<ImageButton>(R.id.olim_habayta)
        olimButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://hometoisrael.co.il/%d7%a4%d7%a0%d7%95-%d7%90%d7%9c%d7%99%d7%a0%d7%95/"))
            startActivity(browserIntent)
        }

        val insuranceButton = view.findViewById<ImageButton>(R.id.national_insurance)
        insuranceButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.btl.gov.il/English%20Homepage/%d7%9e%d7%99%d7%93%d7%a2%20%d7%9c%d7%a7%d7%94%d7%9c%20%d7%99%d7%a2%d7%93/NewOlim/Pages/default.aspx"))
            startActivity(browserIntent)
        }
    }
}