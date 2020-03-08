package com.example.wykaz_podatnikow_vat.ui.bank

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.wykaz_podatnikow_vat.R
import com.example.wykaz_podatnikow_vat.ui.util.Data
import database.merged.TaxPayerWithSubjects
import kotlinx.android.synthetic.main.bank_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.threeten.bp.LocalDate

class BankFragment : Fragment() {


    private val bankViewModel:BankViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupObserver()
        setupButton()
    }

    private fun setupButton() {
        button.setOnClickListener {
            bankViewModel.getTaxPayerByBankAccountAndDate("31872831997646186715413833", LocalDate.parse("2019-02-21"))
        }
    }

    private fun setupObserver() {
        bankViewModel.taxPayer.observe(this, Observer {
            if (it==null)
                return@Observer
            when(it){
                is Data.Success->{
                    textView.text = it.response.toString()
                }
                is Data.Loading->{
                    textView.text = it::class.simpleName
                }
                is Data.Error->{
                    textView.text = it.exception.message
                }
            }
        })
    }

}
