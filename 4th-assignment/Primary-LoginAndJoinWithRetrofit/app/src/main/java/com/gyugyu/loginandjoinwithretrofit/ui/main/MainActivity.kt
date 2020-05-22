package com.gyugyu.loginandjoinwithretrofit.ui.main

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.gyugyu.loginandjoinwithretrofit.R
import com.gyugyu.loginandjoinwithretrofit.base.BaseActivity
import com.gyugyu.loginandjoinwithretrofit.databinding.ActivityMainBinding
import com.gyugyu.loginandjoinwithretrofit.ui.main.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewpager_list_main.adapter = MainPagerAdapter(supportFragmentManager)
        viewpager_list_main.offscreenPageLimit = 2
        viewpager_list_main.addOnPageChangeListener( object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> viewpager_list_main.currentItem = 0;
                R.id.menu_book -> viewpager_list_main.currentItem = 1;
                R.id.menu_person -> viewpager_list_main.currentItem = 2;
            }
            true
        }
    }
}
