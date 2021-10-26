package com.example.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofit.adapters.HomePagerAdapter
import com.example.retrofit.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

private const val ARG_PARAM1 = "param1"

class Home : Fragment() {

    lateinit var fraging: FragmentHomeBinding
    lateinit var homePagerAdapter: HomePagerAdapter
    lateinit var list: ArrayList<String>

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        fraging = FragmentHomeBinding.inflate(inflater, container, false)
        fraging.apply {
            loadCategory()

            homePagerAdapter = HomePagerAdapter(this@Home, list)
            fraging.viewpager2.adapter = homePagerAdapter

            TabLayoutMediator(tablayout, viewpager2) { tab, position ->
                tab.text = list[position]
            }.attach()

        }
        return fraging.root
    }

    private fun loadCategory() {
        list = ArrayList()

        list.add("ALL")
        list.add("NEW")
        list.add("CAR")
        list.add("DESIGN")
        list.add("WOOD")
        list.add("SMILE")
        list.add("AIRPLAN")
        list.add("HOME")
        list.add("FOOD")
    }
}