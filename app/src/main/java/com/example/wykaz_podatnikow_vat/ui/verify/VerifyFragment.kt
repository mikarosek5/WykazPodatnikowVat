package com.example.wykaz_podatnikow_vat.ui.verify

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.wykaz_podatnikow_vat.R

class VerifyFragment : Fragment() {

    companion object {
        fun newInstance() = VerifyFragment()
    }

    private lateinit var viewModel: VerifyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.verify_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VerifyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
