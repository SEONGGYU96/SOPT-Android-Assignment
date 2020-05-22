package com.gyugyu.loginandjoinwithretrofit.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gyugyu.loginandjoinwithretrofit.ui.main.fragment.HomeFragment
import com.gyugyu.loginandjoinwithretrofit.ui.main.fragment.LibraryFragment
import com.gyugyu.loginandjoinwithretrofit.ui.main.fragment.MyPageFragment

class MainPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){ override fun getItem(position: Int): Fragment {
    return when(position){
        0 -> HomeFragment()
        1 -> LibraryFragment() else -> MyPageFragment()
    } }
    override fun getCount() = 3 }