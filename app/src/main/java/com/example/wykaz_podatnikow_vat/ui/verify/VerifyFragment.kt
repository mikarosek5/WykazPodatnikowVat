package com.example.wykaz_podatnikow_vat.ui.verify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.wykaz_podatnikow_vat.R
import com.example.wykaz_podatnikow_vat.ui.verify.tab_adapter.VerifyStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.verify_fragment.*

class VerifyFragment : Fragment() {

    private val adapter by lazy {  VerifyStateAdapter(this)}
    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.verify_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2 = view.findViewById(R.id.pager)
        viewPager2.adapter = adapter
        TabLayoutMediator(tab_layout, viewPager2) { tab, position ->
            when(position){
                0 ->{tab.text ="NIP"}
                1->{tab.text ="REGON"}
            }
        }.attach()

    }


}
