package com.example.retrofit.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.retrofit.fragments.IsFragment

class HomePagerAdapter(fm: Fragment, var list: List<String>) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {
        return IsFragment.newInstance(list[position])
    }
}