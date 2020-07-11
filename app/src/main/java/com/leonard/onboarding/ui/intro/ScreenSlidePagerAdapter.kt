package com.leonard.onboarding.ui.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.leonard.onboarding.common.INTRO_STRING_OBJECT

class ScreenSlidePagerAdapter(
    fragment: Fragment,
    private val listOfPagerContents: List<Array<String>>,
    private val mPageNumbers :Int
) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = mPageNumbers

    override fun createFragment(position: Int): Fragment {
        val fragment = ViewPagerContentFragment()

        when(position){
            0 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(INTRO_STRING_OBJECT, listOfPagerContents[0])
                }
            1 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(INTRO_STRING_OBJECT, listOfPagerContents[1])
                }
            2 ->
                fragment.arguments = Bundle().apply {
                    putStringArray(INTRO_STRING_OBJECT, listOfPagerContents[2])
                }
        }
        return fragment
    }
}