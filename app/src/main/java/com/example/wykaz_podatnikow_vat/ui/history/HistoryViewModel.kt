package com.example.wykaz_podatnikow_vat.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repository.datasource.TaxPayerRepository
import com.example.wykaz_podatnikow_vat.ui.util.Data
import database.merged.TaxPayerWithSubjects
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HistoryViewModel(private val repository: TaxPayerRepository) : ViewModel() {

    private val _history = MutableLiveData<Data<List<TaxPayerWithSubjects>>>()
    private val dispose = CompositeDisposable()
    val history: LiveData<Data<List<TaxPayerWithSubjects>>>
        get() = _history

    fun getHistory() {
        dispose.add(repository
            .getHistory()
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { _history.postValue(Data.Success(it)) },
                { _history.postValue(Data.Error(it)) }
            ))
    }

    override fun onCleared() {
        dispose.clear()
        super.onCleared()
    }

}
