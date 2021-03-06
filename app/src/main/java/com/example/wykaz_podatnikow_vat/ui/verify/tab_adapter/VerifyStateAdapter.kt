package com.example.wykaz_podatnikow_vat.ui.verify.tab_adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wykaz_podatnikow_vat.ui.verify.nip.NipBankVerifyFragment
import com.example.wykaz_podatnikow_vat.ui.verify.regon.RegonBankVerifyFragment
import java.lang.UnsupportedOperationException

class VerifyStateAdapter(fragment:Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2


    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        return when(position){
            0->{
                NipBankVerifyFragment()
            }
            1->{
                RegonBankVerifyFragment()
            }
            else->{throw UnsupportedOperationException("Fragment not found")}
        }
    }

}