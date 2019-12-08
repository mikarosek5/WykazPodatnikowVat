package com.example.wykaz_podatnikow_vat.ui.bank

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.wykaz_podatnikow_vat.R

class BankFragment : Fragment() {

    companion object {
        fun newInstance() = BankFragment()
    }

    private lateinit var viewModel: BankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BankViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
