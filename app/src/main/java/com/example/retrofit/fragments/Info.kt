package com.example.retrofit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofit.R
import com.example.retrofit.classes.Result
import com.example.retrofit.databinding.FragmentInfoBinding
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Info : Fragment() {
    private var result: String? = null

    lateinit var fraging: FragmentInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fraging = FragmentInfoBinding.inflate(inflater, container, false)
        fraging.apply {
            Picasso.get().load(result).into(image)
        }
        return fraging.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Info().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}