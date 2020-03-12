package com.example.wykaz_podatnikow_vat.ui.verify.nip

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.wykaz_podatnikow_vat.R

class NipBankVerifyFragment : Fragment() {

    companion object {
        fun newInstance() = NipBankVerifyFragment()
    }

    private lateinit var viewModel: NipBankVerifyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nip_bank_verify_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NipBankVerifyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
