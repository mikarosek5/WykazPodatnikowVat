package com.example.wykaz_podatnikow_vat.ui.history

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer

import com.example.wykaz_podatnikow_vat.R
import com.example.wykaz_podatnikow_vat.ui.util.Data
import kotlinx.android.synthetic.main.history_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment() {

    private val historyViewModel:HistoryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.history_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        historyViewModel.getHistory()
        showHistory()
    }

    private fun showHistory() {
        historyViewModel.history.observe(this, Observer {
            if (it==null)
                return@Observer
            when(it){
                is Data.Success ->{
                    Toast.makeText(this.context,it.response.size.toString(),Toast.LENGTH_LONG).show()
                    textView.text = it.response.toString()
                }
                is Data.Error->{
                    Toast.makeText(this.context,it.exception.message,Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}
