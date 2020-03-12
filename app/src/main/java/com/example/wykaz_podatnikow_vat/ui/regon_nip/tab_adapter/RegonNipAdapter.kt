package com.example.wykaz_podatnikow_vat.ui.regon_nip.tab_adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wykaz_podatnikow_vat.ui.regon_nip.nip.NipFragment
import com.example.wykaz_podatnikow_vat.ui.regon_nip.regon.RegonFragment
import java.lang.UnsupportedOperationException

class RegonNipAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{NipFragment()}
            1->{RegonFragment()}
            else->{throw UnsupportedOperationException("Fragment not found")}
        }
    }
}