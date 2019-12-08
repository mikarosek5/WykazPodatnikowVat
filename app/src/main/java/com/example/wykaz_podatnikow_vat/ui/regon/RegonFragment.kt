package com.example.wykaz_podatnikow_vat.ui.regon

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.wykaz_podatnikow_vat.R

class RegonFragment : Fragment() {

    companion object {
        fun newInstance() = RegonFragment()
    }

    private lateinit var viewModel: RegonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.regon_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
