package com.leonard.onboarding.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.leonard.onboarding.R
import com.leonard.onboarding.common.INTRO_STRING_OBJECT
import kotlinx.android.synthetic.main.view_pager_content.*
import kotlinx.android.synthetic.main.view_pager_content.skip_text as skip_text_view
import kotlinx.android.synthetic.main.view_pager_content.view_pager_header as intro_head_text
import kotlinx.android.synthetic.main.view_pager_content.view_pager_sub_text as intro_sub_text
import kotlinx.android.synthetic.main.view_pager_content.base_linear as base_layout

class ViewPagerContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.view_pager_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arguments?.takeIf { it.containsKey(INTRO_STRING_OBJECT) }?.apply {
            intro_head_text.text = getStringArray(INTRO_STRING_OBJECT)!![0]
            intro_sub_text.text = getStringArray(INTRO_STRING_OBJECT)!![1]
            changeColor(getStringArray(INTRO_STRING_OBJECT)!![2])
        }

        skip_text_view.setOnClickListener {
            Toast.makeText(requireContext(),"Voila",Toast.LENGTH_SHORT).show()
        }
    }

    private fun changeColor(color:String){
        when(color)
        {
            "R" ->
                base_layout.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
            "B" ->
                base_layout.setBackgroundColor(resources.getColor(android.R.color.holo_blue_dark))
            "G" ->
                base_layout.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
        }
    }
}