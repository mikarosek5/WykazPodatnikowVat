package com.example.wykaz_podatnikow_vat.ui.bank

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repository.datasource.TaxPayerRepository
import com.example.wykaz_podatnikow_vat.ui.util.Data
import database.merged.TaxPayerWithSubjects
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.LocalDate
import java.lang.Exception

class BankViewModel(
    private val repository: TaxPayerRepository,
    private val disposable: CompositeDisposable
) : ViewModel() {

    private val _taxPayer = MutableLiveData<Data<TaxPayerWithSubjects>>()
    val taxPayer: LiveData<Data<TaxPayerWithSubjects>>
        get() = _taxPayer

    fun getTaxPayerByBankAccountAndDate(bankNumber:String,date: LocalDate){
        _taxPayer.postValue(Data.Loading)
        disposable.add(repository
            .getTaxAndSaveIntoBase(bankNumber,date)
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe { _taxPayer.postValue(Data.Success(it)) })
    }





    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}
